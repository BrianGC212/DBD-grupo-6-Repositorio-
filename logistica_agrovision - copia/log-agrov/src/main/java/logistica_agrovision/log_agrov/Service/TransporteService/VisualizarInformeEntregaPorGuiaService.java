package logistica_agrovision.log_agrov.Service.TransporteService;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarInformeEntregaPorGuiaDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarInformeEntregaPorGuiaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
@Service
public class VisualizarInformeEntregaPorGuiaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarInformeEntregaPorGuiaDto> obtenerInformeEntregaPorGuia(RegistrarInformeEntregaPorGuiaDto dto) {
        String sql = "SELECT * FROM vista_informe_entrega WHERE cod_guia_remision = ?";

        return jdbcTemplate.query(sql, new Object[]{dto.getCod_guia_remision()}, (ResultSet rs, int rowNum) -> {
            VisualizarInformeEntregaPorGuiaDto detalle = new VisualizarInformeEntregaPorGuiaDto();
            detalle.setCod_guia_remision(rs.getString("cod_guia_remision"));
            detalle.setCod_empleado(rs.getString("cod_empleado"));
            detalle.setNombre_receptor(rs.getString("nombre_receptor"));
            detalle.setDni_receptor(rs.getString("dni_receptor"));
            detalle.setFecha_entrega(rs.getString("fecha_entrega"));
            detalle.setHora_entrega(rs.getString("hora_entrega"));
            detalle.setObservacion(rs.getString("observacion"));
            return detalle;
        });
    }
}
