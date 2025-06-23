package logistica_agrovision.log_agrov.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarGuiaRemisionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerGuiaRemision() {
        String sql = "SELECT o.cod_orden_transporte, g.cod_guia_remision, e.cod_empleado, v.placa_vehiculo, tipo_vehiculo, fecha_de_traslado, " +
                "CASE WHEN EXISTS (SELECT 1 FROM informe_entrega WHERE id_guia_remision = g.id_guia_remision) THEN 'SI' ELSE 'NO' END as entregado " +
        "FROM guia_de_remision g " +
        "LEFT JOIN guia_x_orden_transporte gxo ON g.id_guia_remision = gxo.id_guia_remision " +
        "LEFT JOIN orden_transporte o ON o.id_orden_transporte = gxo.id_orden_transporte " +
        "INNER JOIN empleado e ON e.id_empleado = g.id_transportista " +
        "INNER JOIN vehiculo v ON v.id_vehiculo = g.id_vehiculo;";

        return jdbcTemplate.queryForList(sql);
    }
}
