package logistica_agrovision.log_agrov.Service.TrazabilidadService;



import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarProcesoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class VisualizarProcesoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Obtiene todos los procesos con su información básica para la visualización general (carga de página o volver).
     *
     * @return Lista de procesos representados como VisualizarProcesoDto.
     */
    public List<VisualizarProcesoDto> obtenerProcesos() {
        String sql = """
            SELECT 
                P.cod_procesos AS codigo,
                P.tipo_proceso AS proceso,
                P.fecha_actualizada,
                P.hora_actualizada,
                P.estado
            FROM procesos P
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToDto(rs));
    }

    /**
     * Busca procesos por código exacto para la barra de búsqueda.
     *
     * @param codigo Código del proceso a buscar.
     * @return Lista con el proceso encontrado (puede estar vacía si no hay coincidencia).
     */
    public List<VisualizarProcesoDto> buscarPorCodigo(String codigo) {
        String sql = """
            SELECT 
                P.cod_procesos AS codigo,
                P.tipo_proceso AS proceso,
                P.fecha_actualizada,
                P.hora_actualizada,
                P.estado
            FROM procesos P
            WHERE P.cod_procesos = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{codigo}, (rs, rowNum) -> mapToDto(rs));
    }

    /**
     * Convierte un ResultSet a un DTO VisualizarProcesoDto.
     *
     * @param rs ResultSet obtenido de la consulta.
     * @return DTO con los datos del proceso.
     * @throws SQLException En caso de error de acceso a columnas.
     */
    private VisualizarProcesoDto mapToDto(ResultSet rs) throws SQLException {
        return new VisualizarProcesoDto(
            rs.getString("codigo"),
            rs.getString("proceso"),
            rs.getDate("fecha_actualizada"),
            rs.getTime("hora_actualizada").toLocalTime(),
            rs.getString("estado")
        );
    }
}
