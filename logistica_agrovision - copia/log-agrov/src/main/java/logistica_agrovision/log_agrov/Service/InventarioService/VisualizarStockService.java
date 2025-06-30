package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarStockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarStockService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarStockDto> obtenerStockProductos() {
        String sql = "SELECT " +
                "p.nombre_producto, " +
                "COALESCE(SUM(CASE WHEN mi.id_tipo_movimiento = 'E' THEN mi.cantidad " +
                "                 WHEN mi.id_tipo_movimiento = 'S' THEN -mi.cantidad " +
                "            END), 0) AS stock_disponible, " +
                "s.stock_minimo, " +
                "s.stock_maximo " +
                "FROM Producto p " +
                "LEFT JOIN Stock s ON p.id_producto = s.id_producto " +
                "LEFT JOIN Movimiento_inventario mi ON p.id_producto = mi.id_producto " +
                "GROUP BY p.nombre_producto, s.stock_minimo, s.stock_maximo " +
                "ORDER BY p.nombre_producto";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VisualizarStockDto dto = new VisualizarStockDto();
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setStockDisponible(rs.getInt("stock_disponible"));
            dto.setStockMinimo(rs.getInt("stock_minimo"));
            dto.setStockMaximo(rs.getInt("stock_maximo"));
            return dto;
        });
    }

    public List<VisualizarStockDto> obtenerStockPorProducto(String nombreProducto) {
        String sql = "SELECT " +
                "p.nombre_producto, " +
                "COALESCE(SUM(CASE WHEN mi.id_tipo_movimiento = 'E' THEN mi.cantidad " +
                "                 WHEN mi.id_tipo_movimiento = 'S' THEN -mi.cantidad " +
                "            END), 0) AS stock_disponible, " +
                "s.stock_minimo, " +
                "s.stock_maximo " +
                "FROM Producto p " +
                "LEFT JOIN Stock s ON p.id_producto = s.id_producto " +
                "LEFT JOIN Movimiento_inventario mi ON p.id_producto = mi.id_producto " +
                "WHERE p.nombre_producto ILIKE '%' || ? || '%' " +
                "GROUP BY p.nombre_producto, s.stock_minimo, s.stock_maximo " +
                "ORDER BY p.nombre_producto";

        return jdbcTemplate.query(sql, new Object[]{nombreProducto}, (rs, rowNum) -> {
            VisualizarStockDto dto = new VisualizarStockDto();
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setStockDisponible(rs.getInt("stock_disponible"));
            dto.setStockMinimo(rs.getInt("stock_minimo"));
            dto.setStockMaximo(rs.getInt("stock_maximo"));
            return dto;
        });
    }

}
