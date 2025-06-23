package logistica_agrovision.log_agrov.Service.TransporteService;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarOrdenXGuiaPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarOrdenXGuiaPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarSeguimientoPorOrdenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class VisualizarOrdenXGuiaPorOrdenService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarOrdenXGuiaPorOrdenDto> obtenerOrdenXGuiaPorOrden(RegistrarOrdenXGuiaPorOrdenDto dto) {
        String sql = "SELECT ot.cod_orden_transporte, g.cod_guia_remision FROM GUIA_X_ORDEN_TRANSPORTE gxo " +
                "INNER JOIN orden_transporte ot ON gxo.id_orden_transporte = ot.id_orden_transporte " +
                "INNER JOIN guia_de_remision g ON gxo.id_guia_remision = g.id_guia_remision " +
                "WHERE ot.cod_orden_transporte = ?";

        return jdbcTemplate.query(sql, new Object[]{dto.getCod_orden_transporte()}, (ResultSet rs, int rowNum) -> {
            VisualizarOrdenXGuiaPorOrdenDto detalle = new VisualizarOrdenXGuiaPorOrdenDto();
            detalle.setCod_orden_transporte(rs.getString("cod_orden_transporte"));
            detalle.setCod_guia_remision(rs.getString("cod_guia_remision"));
            return detalle;
        });
    }
}
