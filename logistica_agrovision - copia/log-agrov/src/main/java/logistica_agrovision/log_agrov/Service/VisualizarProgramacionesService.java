package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.VisualizarProgramacionesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VisualizarProgramacionesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> obtenerProgramaciones() {
        String sql = "SELECT p.COD_PLANIFICACIONES_ASIGNACION AS codigo_planificacion, " +
                     "e.Nombre_equipo AS equipo, a.Nombre_del_area AS area, " +
                     "es.Nombre_Apellido AS responsable, p.Fecha_de_asignacion AS fecha_de_inicio, " +
                     "p.Fecha_de_vencimiento AS fecha_de_fin, p.Descripcion_de_tarea AS descripcion " +
                     "FROM PLANIFICACIONES_ASIGNACION p " +
                     "LEFT JOIN Area a ON p.ID_Area = a.ID_Area " +
                     "LEFT JOIN EQUIPOS e ON p.ID_EQUIPOS = e.ID_EQUIPOS " +
                     "LEFT JOIN Empleado es ON p.ID_Empleado_Solicita = es.ID_Empleado " +
                     "ORDER BY p.COD_PLANIFICACIONES_ASIGNACION ASC";

        return jdbcTemplate.queryForList(sql);
    }
}
