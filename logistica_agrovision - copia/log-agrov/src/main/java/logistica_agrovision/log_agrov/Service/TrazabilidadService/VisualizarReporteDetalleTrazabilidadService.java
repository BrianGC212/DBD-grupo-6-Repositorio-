package logistica_agrovision.log_agrov.Service.TrazabilidadService;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarReporteDetalleTrazabilidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class VisualizarReporteDetalleTrazabilidadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<VisualizarReporteDetalleTrazabilidadDto> obtenerPorCodigo(String codReporte) {
        String sql = """
            SELECT 
                R.cod_reporte_trazabilidad AS Codigo,
                P.cod_procesos AS Proceso,
                R.fecha AS "Fecha Actualizada",
                R.hora AS "Hora Actualizada",
                R.estado,
                R.firmas,
                R.anexos
            FROM REPORTE_TRAZABILIDAD R
            JOIN PROCESOS P ON R.id_procesos = P.id_procesos
            WHERE R.cod_reporte_trazabilidad = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{codReporte}, rs -> {
            if (rs.next()) {
                return Optional.of(mapToDto(rs));
            }
            return Optional.empty();
        });
    }

    private VisualizarReporteDetalleTrazabilidadDto mapToDto(ResultSet rs) throws SQLException {
        return new VisualizarReporteDetalleTrazabilidadDto(
            rs.getString("Codigo"),
            rs.getString("Proceso"),
            rs.getDate("Fecha Actualizada"),
            rs.getTime("Hora Actualizada").toLocalTime(),
            rs.getString("estado"),
            rs.getString("firmas"),
            rs.getString("anexos")
        );
    }
}
