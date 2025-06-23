package logistica_agrovision.log_agrov.Service.RecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VisualizarLotesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerLotes() {
        String sql = "SELECT " +
                "l.cod_lote, " +
                "p.nombre_producto, " +
                "tl.descripcion AS tipo_del_lote, " +
                "l.fecha_produccion, " +
                "l.cantidad_total AS cantidad, " +
                "l.unidad, " +
                "el.descripcion AS estado_lote " +
                "FROM Lote l " +
                "INNER JOIN Producto p ON l.id_producto = p.id_producto " +
                "INNER JOIN Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote " +
                "INNER JOIN Estado_Lote el ON l.id_estado_lote = el.id_estado_lote";

        return jdbcTemplate.queryForList(sql);
    }

public List<Map<String, Object>> buscarLotesPorProducto(String nombreProducto) {
    String sql = "SELECT " +
            "l.cod_lote, " +
            "p.nombre_producto, " +
            "tl.descripcion AS tipo_del_lote, " +
            "l.fecha_produccion, " +
            "l.cantidad_total AS cantidad, " +
            "l.unidad, " +
            "el.descripcion AS estado_lote " +
            "FROM Lote l " +
            "INNER JOIN Producto p ON l.id_producto = p.id_producto " +
            "INNER JOIN Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote " +
            "INNER JOIN Estado_Lote el ON l.id_estado_lote = el.id_estado_lote " +
            "WHERE p.nombre_producto ILIKE ?";

    return jdbcTemplate.queryForList(sql, "%" + nombreProducto + "%");
}
}