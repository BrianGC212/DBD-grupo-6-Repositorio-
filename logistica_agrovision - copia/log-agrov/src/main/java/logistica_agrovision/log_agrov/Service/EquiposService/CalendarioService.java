package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.CalendarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Map;

@Service
public class CalendarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**

     *
     * @param fecha
      @return 
     */
    public List<Map<String, Object>> obtenerEquiposYAreasPorFecha(String fecha) {
        try {
            
            String sql = "SELECT e.Nombre_equipo AS equipo, a.Nombre_del_area AS area " +
                         "FROM PLANIFICACIONES_ASIGNACION p " +
                         "JOIN EQUIPOS e ON p.ID_EQUIPOS = e.ID_EQUIPOS " +
                         "JOIN Area a ON p.ID_Area = a.ID_Area " +
                         "WHERE ?::date BETWEEN p.Fecha_de_asignacion AND p.Fecha_de_vencimiento " +
                         "ORDER BY e.Nombre_equipo";
            
            
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, fecha);

            
            if (result.isEmpty()) {
                return null;
            }

            return result;
        } catch (EmptyResultDataAccessException e) {
            // Si no se encuentra ningún resultado
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la programación del equipo: " + e.getMessage());
        }
    }
}
