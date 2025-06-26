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

    public Map<String, Object> obtenerDatosDelLote(int idLote) {
        String sql = "SELECT " +
                     "l.cod_lote, " +
                     "p.nombre_producto, " +
                     "l.cantidad_total AS cantidad, " +
                     "l.unidad " +
                     "FROM Lote l " +
                     "JOIN Producto p ON l.id_producto = p.id_producto " +
                     "WHERE l.id_lote = ?";
        return jdbcTemplate.queryForMap(sql, idLote);
    }

    public boolean registrarRecepcionAprobada(int idLote, double cantidadRecibida) {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM Recepcion", Integer.class);
            String codRecepcion = "REC" + String.format("%05d", count + 1);

            String sql = "INSERT INTO Recepcion (cod_recepcion, fecha_registro, cantidad_recibida, id_estado_recepcion, observaciones, id_lote) " +
                         "VALUES (?, CURRENT_DATE, ?, 'A', NULL, ?)";
            jdbcTemplate.update(sql, codRecepcion, cantidadRecibida, idLote);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean registrarRecepcionObservada(int idLote, double cantidadRecibida, String observaciones) {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM Recepcion", Integer.class);
            String codRecepcion = "REC" + String.format("%05d", count + 1);

            String sql = "INSERT INTO Recepcion (cod_recepcion, fecha_registro, cantidad_recibida, id_estado_recepcion, observaciones, id_lote) " +
                         "VALUES (?, CURRENT_DATE, ?, 'O', ?, ?)";
            jdbcTemplate.update(sql, codRecepcion, cantidadRecibida, observaciones, idLote);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
