package logistica_agrovision.log_agrov.Service.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VisualizarRecepcionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerRecepciones() {
        String sql = """
            SELECT
                r.cod_recepcion,
                p.nombre_producto,
                tl.descripcion AS descripcion_lote,
                l.cantidad_total AS cantidad,
                l.unidad AS unidad,
                er.descripcion AS estado_recepcion
            FROM
                Recepcion r
            JOIN
                Lote l ON r.id_lote = l.id_lote
            JOIN
                Producto p ON l.id_producto = p.id_producto
            JOIN
                Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote
            JOIN
                Estado_Recepcion er ON r.id_estado_recepcion = er.id_estado_recepcion
            WHERE
                r.id_estado_recepcion = 'A'
        """;

        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> buscarRecepcionesPorProducto(String nombreProducto) {
        String sql = """
            SELECT
                r.cod_recepcion,
                p.nombre_producto,
                tl.descripcion AS descripcion_lote,
                l.cantidad_total AS cantidad,
                l.unidad AS unidad,
                er.descripcion AS estado_recepcion
            FROM
                Recepcion r
            JOIN
                Lote l ON r.id_lote = l.id_lote
            JOIN
                Producto p ON l.id_producto = p.id_producto
            JOIN
                Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote
            JOIN
                Estado_Recepcion er ON r.id_estado_recepcion = er.id_estado_recepcion
            WHERE
                r.id_estado_recepcion = 'A'
                AND p.nombre_producto ILIKE ?
        """;

        String parametroBusqueda = "%" + nombreProducto + "%";
        return jdbcTemplate.queryForList(sql, parametroBusqueda);
    }
}
