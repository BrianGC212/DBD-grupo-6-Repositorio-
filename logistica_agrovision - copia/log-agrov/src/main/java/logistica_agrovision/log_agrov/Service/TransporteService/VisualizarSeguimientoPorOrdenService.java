package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarSeguimientoPorOrdenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.ResultSet;

@Service
public class VisualizarSeguimientoPorOrdenService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarSeguimientoPorOrdenDto> obtenerSeguimientoPorOrden(RegistrarSeguimientoPorOrdenDto dto) {
        String sql = "SELECT * FROM vista_seguimiento_ordenes_transporte WHERE cod_orden_transporte = ?";

        return jdbcTemplate.query(sql, new Object[]{dto.getCod_orden_transporte()}, (ResultSet rs, int rowNum) -> {
            VisualizarSeguimientoPorOrdenDto detalle = new VisualizarSeguimientoPorOrdenDto();
            detalle.setCod_orden_transporte(rs.getString("cod_orden_transporte"));
            detalle.setCod_empleado(rs.getString("cod_empleado"));
            detalle.setDescripcion(rs.getString("descripcion"));
            detalle.setFecha_registro(rs.getString("fecha_registro"));
            detalle.setHora_registro(rs.getString("hora_registro"));
            detalle.setEstado(rs.getString("estado"));
            return detalle;
        });
    }
}
