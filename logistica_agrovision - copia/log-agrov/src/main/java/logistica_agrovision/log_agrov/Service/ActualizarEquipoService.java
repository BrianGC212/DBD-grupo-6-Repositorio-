package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.ActualizarEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActualizarEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String actualizarEstadoEquipo(ActualizarEquipoDto actualizaEquipoDto) {
        // Verificar si el equipo existe
        String sqlCheck = "SELECT COUNT(*) FROM EQUIPOS WHERE COD_Equipos = ?";
        int existeEquipo = jdbcTemplate.queryForObject(sqlCheck, Integer.class, actualizaEquipoDto.getCodigoEquipo());

        if (existeEquipo > 0) {
            // Verificar si el equipo tiene ya una fecha de salida (si ya está fuera de servicio)
            String sqlFechaSalida = "SELECT Fecha_salida FROM EQUIPOS WHERE COD_Equipos = ?";
            String fechaSalida = jdbcTemplate.queryForObject(sqlFechaSalida, String.class, actualizaEquipoDto.getCodigoEquipo());

            if (fechaSalida != null) {
                return "Este equipo ya está fuera de servicio y no puede actualizar su estado.";
            }

            // Verificar si el nuevo estado existe en la tabla Estado_Equipo
            String sqlCheckEstado = "SELECT COUNT(*) FROM Estado_Equipo WHERE ID_Estado_equipo = ?";
            int existeEstado = jdbcTemplate.queryForObject(sqlCheckEstado, Integer.class, actualizaEquipoDto.getNuevoEstado());

            if (existeEstado > 0) {
                // Actualizar el estado del equipo
                String sqlUpdate = "UPDATE EQUIPOS SET ID_Estado_equipo = ?, Fecha_registro = NOW() WHERE COD_Equipos = ?";
                jdbcTemplate.update(sqlUpdate, actualizaEquipoDto.getNuevoEstado(), actualizaEquipoDto.getCodigoEquipo());

                // Si el nuevo estado es "fuera de servicio" (Ej. 'FSE'), actualizar la fecha de salida (Fecha_salida)
                if (actualizaEquipoDto.getNuevoEstado().equals("FSE")) {  // Suponiendo que 'FSE' es el código de "fuera de servicio"
                    String sqlFechaFin = "UPDATE EQUIPOS SET Fecha_salida = NOW() WHERE COD_Equipos = ?";
                    jdbcTemplate.update(sqlFechaFin, actualizaEquipoDto.getCodigoEquipo());
                }

                return "Estado del equipo actualizado exitosamente.";
            } else {
                return "Estado no válido. El estado proporcionado no existe en la tabla Estado_Equipo.";
            }
        } else {
            return "Equipo no encontrado.";
        }
    }
}

