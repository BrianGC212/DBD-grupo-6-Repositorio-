package logistica_agrovision.log_agrov.Service.RecepcionService;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.FormularioReporteProductoDto;
import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroReporteProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReporteProductoObservadoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FormularioReporteProductoDto obtenerDatosFormulario(Integer idControlCalidad) {
        String sql = """
            SELECT 
                l.cod_lote,
                p.nombre_producto
            FROM 
                Control_de_calidad cc
            JOIN Recepcion r ON cc.id_recepcion = r.id_recepcion
            JOIN Lote l ON r.id_lote = l.id_lote
            JOIN Producto p ON l.id_producto = p.id_producto
            WHERE cc.id_control_de_calidad = ?
        """;

        return jdbcTemplate.queryForObject(sql, new Object[]{idControlCalidad}, (rs, rowNum) -> {
            FormularioReporteProductoDto dto = new FormularioReporteProductoDto();
            dto.setCodLote(rs.getString("cod_lote"));
            dto.setNombreProducto(rs.getString("nombre_producto"));
            dto.setIdControlDeCalidad(idControlCalidad);
            return dto;
        });
    }

    public void registrarReporte(RegistroReporteProductoDto dto) {
        String sql = """
            INSERT INTO reporte_producto_observado (
                fecha_registro,
                especificacion_no_cumplida,
                acciones_a_tomar,
                id_control_de_calidad
            )
            VALUES (
                CURRENT_DATE,
                ?, ?, ?
            )
        """;

        jdbcTemplate.update(sql,
                dto.getEspecificacionNoCumplida(),
                dto.getAccionesATomar(),
                dto.getIdControlDeCalidad());
    }
}
