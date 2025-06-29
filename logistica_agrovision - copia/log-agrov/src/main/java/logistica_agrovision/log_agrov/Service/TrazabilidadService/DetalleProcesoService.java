package logistica_agrovision.log_agrov.Service.TrazabilidadService;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.DetalleProcesoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DetalleProcesoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Obtiene los detalles de un proceso específico dado su código.
     *
     * @param codProceso Código del proceso.
     * @return Lista de detalles del proceso.
     */
    public List<DetalleProcesoDto> obtenerDetallePorCodigo(String codProceso) {
        String sql = """
            SELECT 
                P.cod_procesos AS codigo,
                E.nombre_apellido AS supervisor,
                E.cod_empleado AS codigo_empleado,
                TE.descripcion AS tipo_empleado,
                P.hora_actualizada AS hora,
                P.fecha_actualizada AS fecha,
                'Ninguna' AS observaciones
            FROM PROCESOS P
            JOIN Empleado E ON P.id_empleado = E.id_empleado
            JOIN Tipo_Empleado TE ON E.id_tipo_empleado = TE.id_tipo_empleado
            WHERE P.cod_procesos = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{codProceso}, (rs, rowNum) -> mapToDto(rs));
    }

    /**
     * Mapea los resultados de la consulta a un DetalleProcesoDto.
     *
     * @param rs ResultSet de la consulta.
     * @return Instancia de DetalleProcesoDto.
     * @throws SQLException Si ocurre un error de lectura.
     */
    private DetalleProcesoDto mapToDto(ResultSet rs) throws SQLException {
        return new DetalleProcesoDto(
            rs.getString("codigo"),
            rs.getString("supervisor"),
            rs.getString("codigo_empleado"),
            rs.getString("tipo_empleado"),
            rs.getTime("hora").toLocalTime(),
            rs.getDate("fecha"),
            rs.getString("observaciones") // Será siempre "Ninguna"
        );
    }
}

