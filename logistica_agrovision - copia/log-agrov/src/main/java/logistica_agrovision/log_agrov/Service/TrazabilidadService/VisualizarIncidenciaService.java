package logistica_agrovision.log_agrov.Service.TrazabilidadService;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarIncidenciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class VisualizarIncidenciaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Obtiene todas las incidencias con información del proceso asociado.
     *
     * @return Lista de VisualizarIncidenciaDto
     */
    public List<VisualizarIncidenciaDto> obtenerIncidencias() {
        String sql = """
            SELECT 
                I.cod_incidencias AS cod,
                P.tipo_proceso AS proceso,
                I.fecha_registrada AS "Fecha Actualizada",
                I.hora AS "Hora Actualizada",
                I.estado
            FROM INCIDENCIAS I
            JOIN PROCESOS P ON I.id_procesos = P.id_procesos
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToDto(rs));
    }

    private VisualizarIncidenciaDto mapToDto(ResultSet rs) throws SQLException {
        return new VisualizarIncidenciaDto(
            rs.getString("cod"),
            rs.getString("proceso"),
            rs.getDate("Fecha Actualizada"),
            rs.getTime("Hora Actualizada").toLocalTime(),
            rs.getString("estado")
        );
    }
}