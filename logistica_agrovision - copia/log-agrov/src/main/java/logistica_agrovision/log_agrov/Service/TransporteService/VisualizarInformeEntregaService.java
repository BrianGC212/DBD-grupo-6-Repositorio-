package logistica_agrovision.log_agrov.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarInformeEntregaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerInformeEntrega() {
        String sql = "SELECT g.cod_guia_remision, e.cod_empleado, ie.nombre_receptor,ie.dni_receptor, ie.fecha_entrega, ie.hora_entrega, ie.observacion FROM informe_entrega ie " +
        "INNER JOIN guia_de_remision g ON g.id_guia_remision = ie.id_guia_remision " +
        "INNER JOIN empleado e ON e.id_empleado = g.id_transportista;";

        return jdbcTemplate.queryForList(sql);
    }
}
