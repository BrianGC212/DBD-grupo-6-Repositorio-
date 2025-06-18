package logistica_agrovision.log_agrov.Service.RecepcionService;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.EstadisticaPorMesDto;
import logistica_agrovision.log_agrov.Dto.RecepcionDto.EstadisticaPorProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class EstadisticasRecepcionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EstadisticaPorProductoDto> obtenerEstadisticaPorProducto() {
        String sql = """
            SELECT 
                p.nombre_producto,
                COUNT(*) AS total_recepciones
            FROM 
                Recepcion r
            JOIN 
                Lote l ON r.id_lote = l.id_lote
            JOIN 
                Producto p ON l.id_producto = p.id_producto
            JOIN 
                Tipo_Producto tp ON p.id_tipo_producto = tp.id_tipo_producto
            GROUP BY 
                p.nombre_producto
            ORDER BY 
                total_recepciones DESC
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EstadisticaPorProductoDto dto = new EstadisticaPorProductoDto();
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setTotalRecepciones(rs.getInt("total_recepciones"));
            return dto;
        });
    }

    public List<EstadisticaPorMesDto> obtenerEstadisticaPorMes(LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = """
            SELECT 
                DATE_TRUNC('month', fecha_registro) AS mes,
                COUNT(*) AS total_recepciones
            FROM 
                Recepcion
            WHERE 
                fecha_registro >= ? AND fecha_registro < ?
            GROUP BY 
                DATE_TRUNC('month', fecha_registro)
            ORDER BY 
                mes
        """;

        return jdbcTemplate.query(sql, new Object[]{Date.valueOf(fechaInicio), Date.valueOf(fechaFin)}, (rs, rowNum) -> {
            EstadisticaPorMesDto dto = new EstadisticaPorMesDto();
            dto.setMes(rs.getDate("mes").toLocalDate());
            dto.setTotalRecepciones(rs.getInt("total_recepciones"));
            return dto;
        });
    }
}
