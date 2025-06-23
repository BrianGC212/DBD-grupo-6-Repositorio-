package logistica_agrovision.log_agrov.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarOrdenesTransporteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerOrdenesTransporte() {
        String sql = "SELECT o.cod_orden_transporte, e.cod_empleado, o.fecha_salida, o.hora_salida, " +
                "o.fecha_finalizado AS Fecha_finalizada, eo.descripcion FROM empleado e INNER JOIN orden_transporte o ON e.id_empleado = o.id_empleado " +
                "INNER JOIN estado_orden_transporte eo ON o.id_estado_orden = eo.id_estado_orden;";

        return jdbcTemplate.queryForList(sql);
    }
}
