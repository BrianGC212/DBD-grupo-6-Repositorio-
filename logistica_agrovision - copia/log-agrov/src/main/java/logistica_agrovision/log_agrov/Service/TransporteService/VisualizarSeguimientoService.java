package logistica_agrovision.log_agrov.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarSeguimientoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerSeguimiento() {
        String sql = "SELECT t1.cod_orden_transporte, t1.cod_empleado, t2.descripcion, t2.fecha_registro, t2.hora_registro, t2.estado "+
        "FROM (SELECT DISTINCT o.cod_orden_transporte, e.cod_empleado FROM guia_x_orden_transporte gxo " +
                "INNER JOIN orden_transporte o ON gxo.id_orden_transporte = o.id_orden_transporte " +
                "INNER JOIN guia_de_remision g ON gxo.id_guia_remision = g.id_guia_remision " +
                "INNER JOIN empleado e ON g.id_transportista = e.id_empleado ORDER BY o.cod_orden_transporte) t1 " +
        "INNER JOIN (SELECT o.cod_orden_transporte as orden_transporte, s.descripcion, s.fecha_registro, s.hora_registro, es.descripcion as estado FROM orden_transporte o " +
        "INNER JOIN seguimiento s ON o.id_orden_transporte = s.id_orden_transporte " +
        "INNER JOIN estado_seguimiento es ON s.id_estado_seguimiento = es.id_estado_seguimiento) t2 ON t1.cod_orden_transporte = t2.orden_transporte;";

        return jdbcTemplate.queryForList(sql);
    }
}
