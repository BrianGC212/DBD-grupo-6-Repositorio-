package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarReporteInventarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarReporteInventarioService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarReporteInventarioDto> obtenerReporteInventario() {
        String sql = "SELECT " +
                "ri.cod_reporte_inventario, " +
                "ri.fecha_inventario, " +
                "rid.id_detalle, " +
                "rid.id_lote, " +
                "rid.cantidad_esperada, " +
                "rid.cantidad_real, " +
                "rid.diferencia, " +
                "rid.observacion " +
                "FROM Reporte_inventario ri " +
                "JOIN Reporte_inventario_detalle rid ON ri.id_reporte_inventario = rid.id_reporte_inventario" +
                " ORDER BY ri.fecha_inventario DESC, ri.id_reporte_inventario, rid.id_detalle";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VisualizarReporteInventarioDto dto = new VisualizarReporteInventarioDto();
            dto.setCodReporteInventario(rs.getString("cod_reporte_inventario"));
            dto.setFechaInventario(rs.getTimestamp("fecha_inventario").toLocalDateTime());
            dto.setIdDetalle(rs.getInt("id_detalle"));
            dto.setIdLote(rs.getInt("id_lote"));
            dto.setCantidadEsperada(rs.getFloat("cantidad_esperada"));
            dto.setCantidadReal(rs.getFloat("cantidad_real"));
            dto.setDiferencia(rs.getFloat("diferencia"));
            dto.setObservacion(rs.getString("observacion"));
            return dto;
        });
    }

    public List<VisualizarReporteInventarioDto> obtenerReportePorObservacion(String observacion) {
        String sql = "SELECT " +
                "ri.cod_reporte_inventario, " +
                "ri.fecha_inventario, " +
                "rid.id_detalle, " +
                "rid.id_lote, " +
                "rid.cantidad_esperada, " +
                "rid.cantidad_real, " +
                "rid.diferencia, " +
                "rid.observacion " +
                "FROM Reporte_inventario ri " +
                "JOIN Reporte_inventario_detalle rid ON ri.cod_reporte_inventario = rid.cod_reporte_inventario " +
                "WHERE rid.observacion ILIKE '%' || ? || '%'";

        return jdbcTemplate.query(sql, new Object[]{observacion}, (rs, rowNum) -> {
            VisualizarReporteInventarioDto dto = new VisualizarReporteInventarioDto();
            dto.setCodReporteInventario(rs.getString("cod_reporte_inventario"));
            dto.setFechaInventario(rs.getTimestamp("fecha_inventario").toLocalDateTime());
            dto.setIdDetalle(rs.getInt("id_detalle"));
            dto.setIdLote(rs.getInt("id_lote"));
            dto.setCantidadEsperada(rs.getFloat("cantidad_esperada"));
            dto.setCantidadReal(rs.getFloat("cantidad_real"));
            dto.setDiferencia(rs.getFloat("diferencia"));
            dto.setObservacion(rs.getString("observacion"));
            return dto;
        });
    
    }    

}
