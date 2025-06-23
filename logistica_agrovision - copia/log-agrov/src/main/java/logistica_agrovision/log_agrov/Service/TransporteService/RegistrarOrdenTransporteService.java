package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarOrdenTransporteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarOrdenTransporteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarOrden(RegistrarOrdenTransporteDto dto) {
        try {
            // Obtener el número de las ordenes ya registrados
            String sql = "SELECT COUNT(1) FROM orden_transporte";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);

            // El codigo de la orden de transporte será 'EQ' + el número de equipos existentes + 1
            String codigoOrdenTransporte = "OT" + String.format("%06d", count + 1);

            java.sql.Date fechaSalida = java.sql.Date.valueOf(dto.getFecha_salida());
            java.sql.Time horaSalida = java.sql.Time.valueOf(dto.getHora_salida());

            // Insertar el nuevo equipo con la fecha de registro,
            String sqlInsert = "INSERT INTO orden_transporte (id_empleado,cod_orden_transporte, fecha_finalizado, fecha_salida, hora_salida) " +
                    "SELECT id_empleado, ?, NULL, ?,? FROM Empleado WHERE cod_empleado = ?";
            jdbcTemplate.update(sqlInsert, codigoOrdenTransporte, fechaSalida, horaSalida,
                    dto.getCod_empleado());
            // INSERTAR A LA GUIA DE REMISION
            for(int i=0; i< dto.getGuiasRemision().size(); i++){
                sqlInsert = "INSERT INTO guia_x_orden_transporte (id_orden_transporte, id_guia_remision) " +
                        "SELECT id_orden_transporte, id_guia_remision FROM orden_transporte o, guia_de_remision g " +
                        "WHERE o.cod_orden_transporte = ? AND g.cod_guia_remision = ?";
                jdbcTemplate.update(sqlInsert, codigoOrdenTransporte, dto.getGuiasRemision().get(i));

            }
            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }





}
