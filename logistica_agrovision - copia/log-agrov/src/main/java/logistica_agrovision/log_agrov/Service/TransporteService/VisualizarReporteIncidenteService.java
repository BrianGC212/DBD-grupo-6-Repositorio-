package logistica_agrovision.log_agrov.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarReporteIncidenteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerReporteIncidente() {
        String sql = "SELECT g.cod_guia_remision, e.cod_empleado, c.cod_cliente, rie.nombre_realiza, rie.dni_realiza, rie.fecha_registro, rie.hora_registro, eri.descripcion as estado, rie.descripcion " +
        "FROM reporte_incidentes_entrega rie " +
        "INNER JOIN informe_entrega ie ON ie.id_informe_entrega = rie.id_informe_entrega " +
        "INNER JOIN guia_de_remision g ON g.id_guia_remision = ie.id_guia_remision " +
        "INNER JOIN empleado e ON e.id_empleado = rie.id_empleado " +
        "INNER JOIN cliente c ON c.id_cliente = rie.id_cliente " +
        "INNER JOIN estado_reporte_incidentes_transporte eri ON eri.id_estado_reporte = rie.id_estado_reporte;";

        return jdbcTemplate.queryForList(sql);
    }
}
