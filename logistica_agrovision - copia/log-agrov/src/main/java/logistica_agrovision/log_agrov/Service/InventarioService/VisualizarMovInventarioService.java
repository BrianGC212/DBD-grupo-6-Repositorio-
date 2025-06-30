package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarMovInventarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarMovInventarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarMovInventarioDto> obtenerMovInventario() {
        String sql = "SELECT " +
                "mi.cod_movimiento_inventario, " +
                "mi.fecha_movimiento, " +
                "l.cod_lote, " +
                "mi.destino, " +
                "tm.descripcion AS tipo_movimiento_descripcion, " +
                "e.cod_empleado " +
                "FROM Movimiento_inventario AS mi " +
                "JOIN Lote AS l ON mi.id_lote = l.id_lote " +
                "JOIN Tipo_Movimiento AS tm ON mi.id_tipo_movimiento = tm.id_tipo_movimiento " +
                "JOIN Empleado AS e ON mi.id_empleado = e.id_empleado " +
                "ORDER BY mi.fecha_movimiento DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VisualizarMovInventarioDto dto = new VisualizarMovInventarioDto();
            dto.setCodMovimientoInventario(rs.getString("cod_movimiento_inventario"));
            dto.setFechaMovimiento(rs.getTimestamp("fecha_movimiento").toLocalDateTime());
            dto.setCodLote(rs.getString("cod_lote"));
            dto.setDestino(rs.getString("destino"));
            dto.setTipoMovimientoDescripcion(rs.getString("tipo_movimiento_descripcion"));
            dto.setCodEmpleado(rs.getString("cod_empleado"));
            return dto;
        });
    }

    public List<VisualizarMovInventarioDto> obtenerMovInventarioPorLote(String codLote) {
        String sql = "SELECT " +
            "mi.cod_movimiento_inventario, " +
            "mi.fecha_movimiento, " +
            "l.cod_lote, " +
            "mi.destino, " +
            "tm.descripcion AS tipo_movimiento_descripcion, " +
            "e.cod_empleado " +
            "FROM Movimiento_inventario AS mi " +
            "JOIN Lote AS l ON mi.id_lote = l.id_lote " +
            "JOIN Tipo_Movimiento AS tm ON mi.id_tipo_movimiento = tm.id_tipo_movimiento " +
            "JOIN Empleado AS e ON mi.id_empleado = e.id_empleado " +
            "WHERE l.cod_lote ILIKE '%' || ? || '%' " +
            "ORDER BY mi.fecha_movimiento DESC";

        return jdbcTemplate.query(sql, new Object[]{codLote}, (rs, rowNum) -> {
            VisualizarMovInventarioDto dto = new VisualizarMovInventarioDto();
            dto.setCodMovimientoInventario(rs.getString("cod_movimiento_inventario"));
            dto.setFechaMovimiento(rs.getTimestamp("fecha_movimiento").toLocalDateTime());
            dto.setCodLote(rs.getString("cod_lote"));
            dto.setDestino(rs.getString("destino"));
            dto.setTipoMovimientoDescripcion(rs.getString("tipo_movimiento_descripcion"));
            dto.setCodEmpleado(rs.getString("cod_empleado"));
            return dto;
        });
    }

}
