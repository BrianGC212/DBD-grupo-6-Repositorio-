package logistica_agrovision.log_agrov.Service.EquiposService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import logistica_agrovision.log_agrov.Dto.EquiposDto.EquipoDTO;

@Service
public class EquipoVisualizarService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public List<Map<String, Object>> obtenerEquipos() {
        String sql = "SELECT " +
                     "e.COD_Equipos AS \"Código de Máquina\", " +
                     "e.Nombre_equipo AS \"Nombre del Equipo\", " +
                     "tm.Descripcion AS \"Tipo de Máquina\", " +
                     "ee.Descripcion AS \"Estado de Máquina\", " +
                     "e.Fecha_registro AS \"Fecha de Registro\", " +
                     "CASE WHEN ee.ID_Estado_equipo = 'FSE' THEN e.Fecha_salida ELSE NULL END AS \"Fecha de Salida\", " +
                     "e.Detalle AS \"Detalle\" " +
                     "FROM EQUIPOS e " +
                     "JOIN Tipo_Maquina tm ON e.ID_Tipo_Maquina = tm.ID_Tipo_Maquina " +
                     "JOIN Estado_Equipo ee ON e.ID_Estado_equipo = ee.ID_Estado_equipo " +
                     "ORDER BY e.COD_Equipos";

        
        return jdbcTemplate.queryForList(sql);
    }
}
