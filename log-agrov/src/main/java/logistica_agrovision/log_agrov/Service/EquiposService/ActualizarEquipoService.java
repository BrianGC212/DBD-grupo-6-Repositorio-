package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.ActualizarEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActualizarEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String actualizarEstadoEquipo(ActualizarEquipoDto actualizaEquipoDto) {
        
        String sqlCheck = "SELECT COUNT(*) FROM EQUIPOS WHERE COD_Equipos = ?";
        int existeEquipo = jdbcTemplate.queryForObject(sqlCheck, Integer.class, actualizaEquipoDto.getCodigoEquipo());

        if (existeEquipo > 0) {
           
            String sqlFechaSalida = "SELECT Fecha_salida FROM EQUIPOS WHERE COD_Equipos = ?";
            String fechaSalida = jdbcTemplate.queryForObject(sqlFechaSalida, String.class, actualizaEquipoDto.getCodigoEquipo());

            if (fechaSalida != null) {
                return "Este equipo ya está fuera de servicio y no puede actualizar su estado.";
            }

            String sqlCheckEstado = "SELECT COUNT(*) FROM Estado_Equipo WHERE ID_Estado_equipo = ?";
            int existeEstado = jdbcTemplate.queryForObject(sqlCheckEstado, Integer.class, actualizaEquipoDto.getNuevoEstado());

            if (existeEstado > 0) {
           
                String sqlUpdate = "UPDATE EQUIPOS SET ID_Estado_equipo = ?, Fecha_registro = NOW() WHERE COD_Equipos = ?";
                jdbcTemplate.update(sqlUpdate, actualizaEquipoDto.getNuevoEstado(), actualizaEquipoDto.getCodigoEquipo());

                
                if (actualizaEquipoDto.getNuevoEstado().equals("FSE")) {  
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

