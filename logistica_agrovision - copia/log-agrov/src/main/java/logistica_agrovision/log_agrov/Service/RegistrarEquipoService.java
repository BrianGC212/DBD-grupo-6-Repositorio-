package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.RegistrarEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarEquipo(RegistrarEquipoDto dto) {
        try {
            // Obtener el número de equipos ya registrados
            String sql = "SELECT COUNT(1) FROM EQUIPOS";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);

            // El código de equipo será 'EQ' + el número de equipos existentes + 1
            String codigoEquipo = "EQ" + String.format("%06d", count + 1);

            // Obtener tipo de máquina (pero no cambiar el estado, debe ser 'OPE')
            String sqlTipo = "SELECT Descripcion FROM Tipo_Maquina WHERE ID_Tipo_Maquina = ?";
            String tipoMaquina = jdbcTemplate.queryForObject(sqlTipo, String.class, dto.getTipoMaquinaId());

            // El estado siempre será 'OPE'
            String estadoMaquina = "OPE"; // Estado fijo como OPE

            // Obtener fecha actual para la fecha de registro
            java.sql.Date fechaRegistro = new java.sql.Date(System.currentTimeMillis());

            // Insertar el nuevo equipo con la fecha de registro, sin tocar la fecha de salida
            String sqlInsert = "INSERT INTO EQUIPOS (COD_Equipos, Nombre_equipo, ID_Tipo_Maquina, ID_Estado_equipo, Fecha_registro, Detalle, id_empleado, Fecha_salida) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, NULL)"; // Asegúrate de no tocar Fecha_salida
            jdbcTemplate.update(sqlInsert, codigoEquipo, dto.getNombreEquipo(), dto.getTipoMaquinaId(), 
                                estadoMaquina, fechaRegistro, dto.getDetalle(), dto.getId_empleado());

            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }
}
