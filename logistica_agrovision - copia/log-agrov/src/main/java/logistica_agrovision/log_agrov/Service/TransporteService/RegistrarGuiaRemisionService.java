package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarGuiaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarGuiaRemisionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarGuia(RegistrarGuiaDto dto) {
        try {
            // Obtener el número de guia_de_remision ya registrados
            String sql = "SELECT COUNT(1) FROM guia_de_remision";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);

            // El código de codigoGuia será 'GR' + el número de equipos existentes + 1
            String codigoGuia = "GR" + String.format("%06d", count + 1);

            // Obtener fecha actual para la fecha de registro
            java.sql.Date fechaTraslado = java.sql.Date.valueOf(dto.getFecha_de_traslado());

            String sqlInsert ="INSERT INTO guia_de_remision ( " +
                    "cod_guia_remision, " +
                    "fecha_de_traslado, " +
                    "id_vehiculo, " +
                    "id_informe_de_especificaciones, " +
                    "id_transportista, " +
                    "id_pedido, " +
                    "id_empleado " +
                    ") " +
                    "VALUES ( " +
                    "?, " +
                    "?, " +
                    "(SELECT id_vehiculo FROM vehiculo WHERE placa_vehiculo = ?), " +
                    "'IE000005', " +
                    "(SELECT id_empleado FROM empleado WHERE cod_empleado = ?), " +
                    "(SELECT id_pedido FROM pedido WHERE cod_pedido = ?), " +
                    "(SELECT id_empleado FROM empleado WHERE cod_empleado = ?));";
            jdbcTemplate.update(sqlInsert, codigoGuia, fechaTraslado, dto.getPlaca_vehiculo(),
                    dto.getCod_transportista(), dto.getCod_pedido(), dto.getCod_empleado());

            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }

}
