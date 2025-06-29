package logistica_agrovision.log_agrov.Service.TrazabilidadService;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarDetalleIncidenciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class VisualizarDetalleIncidenciaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<VisualizarDetalleIncidenciaDto> obtenerPorCodigo(String codIncidencia) {
        String sql = """
            SELECT 
                I.cod_incidencias AS Cod,
                P.tipo_proceso AS Proceso,
                I.fecha_registrada AS "Fecha Actualizada",
                I.hora AS "Hora Actualizada",
                I.estado,
                I.evidencias,
                I.observaciones,
                I.fecha_resolucion AS "Fecha Resolucion"
            FROM INCIDENCIAS I
            JOIN PROCESOS P ON I.id_procesos = P.id_procesos
            WHERE I.cod_incidencias = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{codIncidencia}, rs -> {
            if (rs.next()) {
                return Optional.of(mapToDto(rs));
            }
            return Optional.empty();
        });
    }

    private VisualizarDetalleIncidenciaDto mapToDto(ResultSet rs) throws SQLException {
        return new VisualizarDetalleIncidenciaDto(
            rs.getString("Cod"),
            rs.getString("Proceso"),
            rs.getDate("Fecha Actualizada"),
            rs.getTime("Hora Actualizada").toLocalTime(),
            rs.getString("estado"),
            rs.getString("evidencias"),
            rs.getString("observaciones"),
            rs.getDate("Fecha Resolucion")
        );
    }
}