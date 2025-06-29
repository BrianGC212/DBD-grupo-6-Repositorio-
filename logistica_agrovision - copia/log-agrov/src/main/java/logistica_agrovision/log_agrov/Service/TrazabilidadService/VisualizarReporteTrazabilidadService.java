package logistica_agrovision.log_agrov.Service.TrazabilidadService;


import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarReporteTrazabilidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class VisualizarReporteTrazabilidadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisualizarReporteTrazabilidadDto> obtenerReporteTrazabilidad() {
        String sql = """
            SELECT 
                R.cod_reporte_trazabilidad AS codigo,
                P.cod_procesos AS proceso,
                R.fecha AS fecha_actualizada,
                R.hora AS hora_actualizada,
                R.estado
            FROM REPORTE_TRAZABILIDAD R
            INNER JOIN PROCESOS P ON R.id_procesos = P.id_procesos
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToDto(rs));
    }

    private VisualizarReporteTrazabilidadDto mapToDto(ResultSet rs) throws SQLException {
        return new VisualizarReporteTrazabilidadDto(
            rs.getString("codigo"),
            rs.getString("proceso"),
            rs.getDate("fecha_actualizada"),
            rs.getTime("hora_actualizada").toLocalTime(),
            rs.getString("estado")
        );
    }
}