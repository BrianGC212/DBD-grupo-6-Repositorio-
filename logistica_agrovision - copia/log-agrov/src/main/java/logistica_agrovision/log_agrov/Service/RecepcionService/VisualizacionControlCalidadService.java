package logistica_agrovision.log_agrov.Service.RecepcionService;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.VisualizacionControlCalidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizacionControlCalidadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizacionControlCalidadDto> listarObservados() {
        String sql = """
                SELECT
                    cc.cod_control_calidad,
                    p.nombre_producto,
                    tl.descripcion AS descripcion_lote,
                    l.cantidad_total,
                    l.unidad,
                    ecc.descripcion AS estado_control_calidad
                FROM
                    Control_de_calidad cc
                JOIN Recepcion r ON cc.id_recepcion = r.ID_recepcion
                JOIN Lote l ON r.id_lote = l.id_lote
                JOIN Producto p ON l.id_producto = p.id_producto
                JOIN Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote
                JOIN Estado_Control_Calidad ecc ON cc.id_estado_control_calidad = ecc.id_estado_control_calidad
                WHERE cc.id_estado_control_calidad = 'O';
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VisualizacionControlCalidadDto dto = new VisualizacionControlCalidadDto();
            dto.setCodControlCalidad(rs.getString("cod_control_calidad"));
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setDescripcionLote(rs.getString("descripcion_lote"));
            dto.setCantidadTotal(rs.getDouble("cantidad_total"));
            dto.setUnidad(rs.getString("unidad"));
            dto.setEstadoControlCalidad(rs.getString("estado_control_calidad"));
            return dto;
        });
    }

    public List<VisualizacionControlCalidadDto> buscarPorNombreProducto(String nombre) {
        String sql = """
                SELECT
                    cc.cod_control_calidad,
                    p.nombre_producto,
                    tl.descripcion AS descripcion_lote,
                    l.cantidad_total,
                    l.unidad,
                    ecc.descripcion AS estado_control_calidad
                FROM
                    Control_de_calidad cc
                JOIN Recepcion r ON cc.id_recepcion = r.ID_recepcion
                JOIN Lote l ON r.id_lote = l.id_lote
                JOIN Producto p ON l.id_producto = p.id_producto
                JOIN Tipo_Lote tl ON l.id_tipo_lote = tl.id_tipo_lote
                JOIN Estado_Control_Calidad ecc ON cc.id_estado_control_calidad = ecc.id_estado_control_calidad
                WHERE cc.id_estado_control_calidad = 'O'
                  AND p.nombre_producto ILIKE '%' || ? || '%';
                """;

        return jdbcTemplate.query(sql, new Object[]{nombre}, (rs, rowNum) -> {
            VisualizacionControlCalidadDto dto = new VisualizacionControlCalidadDto();
            dto.setCodControlCalidad(rs.getString("cod_control_calidad"));
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setDescripcionLote(rs.getString("descripcion_lote"));
            dto.setCantidadTotal(rs.getDouble("cantidad_total"));
            dto.setUnidad(rs.getString("unidad"));
            dto.setEstadoControlCalidad(rs.getString("estado_control_calidad"));
            return dto;
        });
    }
}
