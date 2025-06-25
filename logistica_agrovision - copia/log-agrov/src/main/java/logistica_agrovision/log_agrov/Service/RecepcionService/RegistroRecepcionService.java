package logistica_agrovision.log_agrov.Service.RecepcionService;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroRecepcionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegistroRecepcionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> obtenerDatosDelLote(String codLote) {
        String sql = "SELECT " +
                     "l.cod_lote, " +
                     "p.nombre_producto, " +
                     "l.cantidad_total AS cantidad, " +
                     "l.unidad " +
                     "FROM Lote l " +
                     "JOIN Producto p ON l.id_producto = p.id_producto " +
                     "WHERE l.cod_lote = ?";
        return jdbcTemplate.queryForMap(sql, codLote);
    }

    public boolean registrarRecepcionAprobada(String codLote, double cantidadRecibida) {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM Recepcion", Integer.class);
            String codRecepcion = "REC" + String.format("%05d", count + 1);

            String sql = "INSERT INTO Recepcion (cod_recepcion, fecha_registro, cantidad_recibida, id_estado_recepcion, observaciones, id_lote) " +
                         "VALUES (?, CURRENT_DATE, ?, 'A', NULL, (SELECT id_lote from Lote WHERE cod_lote = ?))";
            jdbcTemplate.update(sql, codRecepcion, cantidadRecibida, codLote);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean registrarRecepcionObservada(String codLote, double cantidadRecibida, String observaciones) {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM Recepcion", Integer.class);
            String codRecepcion = "REC" + String.format("%05d", count + 1);

            String sql = "INSERT INTO Recepcion (cod_recepcion, fecha_registro, cantidad_recibida, id_estado_recepcion, observaciones, id_lote) " +
                         "VALUES (?, CURRENT_DATE, ?, 'O', ?, (SELECT id_lote from Lote WHERE cod_lote = ?))";
            jdbcTemplate.update(sql, codRecepcion, cantidadRecibida, observaciones, codLote);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
