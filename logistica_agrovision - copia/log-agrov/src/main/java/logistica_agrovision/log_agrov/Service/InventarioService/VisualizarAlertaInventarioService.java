package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarAlertaInventarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarAlertaInventarioService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarAlertaInventarioDto> obtenerAlertasInventario() {
        String query = "SELECT " +
                "ai.cod_alerta_inventario, " +
                "ai.estado_alerta, " +
                "ai.tipo_alerta, " +
                "ai.severidad, " +
                "ai.descripcion, " +
                "ai.fecha_hora_alerta, " +
                "ai.fecha_hora_solucion, " +
                "l.cod_lote, " +
                "e.id_empleado " +
                "FROM Alerta_inventario ai " +
                "LEFT JOIN Lote l ON ai.id_lote = l.id_lote " +
                "LEFT JOIN Reporte_inventario ri ON ai.id_reporte_inventario = ri.id_reporte_inventario " +
                "LEFT JOIN Empleado e ON ai.id_empleado_responsable = e.id_empleado " +
                "ORDER BY ai.fecha_hora_alerta DESC";

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            VisualizarAlertaInventarioDto dto = new VisualizarAlertaInventarioDto();
            dto.setCodAlertaInventario(String.valueOf(rs.getString("cod_alerta_inventario")));
            dto.setEstadoAlerta(rs.getString("estado_alerta"));
            dto.setTipoAlerta(rs.getString("tipo_alerta"));
            dto.setSeveridad(rs.getString("severidad"));
            dto.setDescripcion(rs.getString("descripcion"));
            dto.setFechaHoraAlerta(rs.getTimestamp("fecha_hora_alerta").toLocalDateTime());
            dto.setFechaHoraSolucion(rs.getTimestamp("fecha_hora_solucion") != null 
                    ? rs.getTimestamp("fecha_hora_solucion").toLocalDateTime() 
                    : null);
            dto.setCodLote(rs.getString("cod_lote"));
            dto.setIdEmpleado((int) rs.getInt("id_empleado"));
            return dto;
        });
    }

}
