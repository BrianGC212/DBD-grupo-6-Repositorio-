package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.RegistrarEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarEquipo(RegistrarEquipoDto dto) {
        try {
            String sql = "SELECT COUNT(1) FROM EQUIPOS";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);

            String codigoEquipo = "EQ" + String.format("%06d", count + 1);

            
            String sqlTipo = "SELECT Descripcion FROM Tipo_Maquina WHERE ID_Tipo_Maquina = ?";
            String tipoMaquina = jdbcTemplate.queryForObject(sqlTipo, String.class, dto.getTipoMaquinaId());


            String estadoMaquina = "OPE"; 

            java.sql.Date fechaRegistro = new java.sql.Date(System.currentTimeMillis());

           
            String sqlInsert = "INSERT INTO EQUIPOS (COD_Equipos, Nombre_equipo, ID_Tipo_Maquina, ID_Estado_equipo, Fecha_registro, Detalle, id_empleado, Fecha_salida) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, NULL)"; 
            jdbcTemplate.update(sqlInsert, codigoEquipo, dto.getNombreEquipo(), dto.getTipoMaquinaId(), 
                                estadoMaquina, fechaRegistro, dto.getDetalle(), dto.getId_empleado());

            return true;
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
    }
}
