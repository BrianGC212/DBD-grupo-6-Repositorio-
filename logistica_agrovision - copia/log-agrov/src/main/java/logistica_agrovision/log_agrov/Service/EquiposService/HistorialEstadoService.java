package logistica_agrovision.log_agrov.Service.EquiposService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import logistica_agrovision.log_agrov.Dto.EquiposDto.HistorialEstadoDto;

@Service
public class HistorialEstadoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public List<HistorialEstadoDto> obtenerHistorialEstado(String codEquipo) {
        String sql = "SELECT he.Fecha, ee.Descripcion AS Estado, he.Detalle " +
                     "FROM Historial_Estado_Equipo he " +
                     "JOIN Estado_Equipo ee ON he.ID_Estado_equipo = ee.ID_Estado_equipo " +
                     "JOIN EQUIPOS e ON he.ID_EQUIPOS = e.ID_EQUIPOS " +
                     "WHERE e.COD_Equipos = ? " +
                     "ORDER BY he.Fecha";
        
        return jdbcTemplate.query(sql, new Object[] {codEquipo}, (rs, rowNum) -> {
            HistorialEstadoDto historial = new HistorialEstadoDto();
            historial.setFecha(rs.getString("Fecha"));
            historial.setEstado(rs.getString("Estado"));
            historial.setDetalle(rs.getString("Detalle"));
            return historial;
        });
    }
}
