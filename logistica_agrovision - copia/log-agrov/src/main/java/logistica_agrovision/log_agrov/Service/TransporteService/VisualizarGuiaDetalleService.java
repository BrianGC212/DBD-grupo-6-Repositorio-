package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarGuiaDetalleDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarGuiaDetalleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class VisualizarGuiaDetalleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarGuiaDetalleDto> obtenerDetalleGuia(RegistrarGuiaDetalleDto dto) {
        String sql = "SELECT pd.id_producto, pd.nombre_producto, pk.peso_neto as cantidad, 'KG' as unidad " +
                "FROM packing pk " +
                "INNER JOIN (SELECT p.id_pedido FROM guia_de_remision g " +
                "INNER JOIN pedido p ON p.id_pedido = g.id_pedido WHERE g.cod_guia_remision = ?) p " +
                "ON p.id_pedido = pk.id_pedido " +
                "INNER JOIN empaque em ON em.id_empaque = pk.id_empaque " +
                "INNER JOIN lote l ON l.id_lote = em.id_lote " +
                "INNER JOIN producto pd ON pd.id_producto = l.id_producto";

        return jdbcTemplate.query(sql, new Object[]{dto.getGuiaDetalle()}, (ResultSet rs, int rowNum) -> {
            VisualizarGuiaDetalleDto detalle = new VisualizarGuiaDetalleDto();
            detalle.setCodProducto(rs.getString("id_producto"));
            detalle.setNombre(rs.getString("nombre_producto"));
            detalle.setPeso(rs.getString("cantidad"));
            detalle.setUnidad(rs.getString("unidad"));
            return detalle;
        });
    }
}

