package logistica_agrovision.log_agrov.Service.PedidosService;


import logistica_agrovision.log_agrov.Models.Picking;
import logistica_agrovision.log_agrov.Models.ProductoPicking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparacionPedidosService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Picking> getPickings(String param) {
        String sql = """
        SELECT
            pe.cod_pedido       AS pedido,
            em.nombre_apellido  AS nombre_empleado,
            pe.fecha_limite     AS fecha_limite,
            pe.destino          AS destino,
            ep.descripcion      AS estado
        FROM
            Pedido pe
            INNER JOIN Packing pk ON pe.id_pedido = pk.id_pedido
            INNER JOIN Empleado em ON pk.id_empleado = em.id_empleado
            INNER JOIN Estado_packing ep ON pk.id_estado_packing = ep.id_estado_packing
        WHERE
            (? IS NULL OR TRIM(?) = '' OR pe.cod_pedido LIKE CONCAT('%', ?, '%'))
        ORDER BY
            pe.fecha_limite ASC
        """;

        // Pasamos el mismo parámetro tres veces para las tres condiciones en el WHERE
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Picking.class), param, param, param);
    }

    public List<ProductoPicking> getProductosPicking(String filtroProducto) {
        String sql = """
        SELECT
            pr.id_producto           AS "ID_PRODUCTO",
            pr.nombre_producto       AS "PRODUCTO",
            SUM(pk.cantidad_producto) AS "CANTIDAD",
            MAX(ar.id_area)          AS "AREA",
            MAX(ep.descripcion)      AS "ESTADO"
        FROM
            Packing pk
            INNER JOIN Empaque emq ON pk.id_empaque = emq.id_empaque
            INNER JOIN Lote l ON emq.id_lote = l.id_lote
            INNER JOIN Producto pr ON l.id_producto = pr.id_producto
            INNER JOIN Empleado em ON pk.id_empleado = em.id_empleado
            INNER JOIN PLANIFICACIONES_ASIGNACION pa ON em.id_empleado = pa.ID_Empleado_Solicita
            INNER JOIN Area ar ON pa.ID_Area = ar.id_area
            INNER JOIN Estado_packing ep ON pk.id_estado_packing = ep.id_estado_packing
        WHERE
            (? IS NULL OR TRIM(?) = '' OR pr.id_producto LIKE CONCAT('%', ?, '%'))
        GROUP BY
            pr.id_producto,
            pr.nombre_producto
        ORDER BY
            pr.id_producto ASC
        """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductoPicking.class),
                filtroProducto, filtroProducto, filtroProducto);
    }
}
