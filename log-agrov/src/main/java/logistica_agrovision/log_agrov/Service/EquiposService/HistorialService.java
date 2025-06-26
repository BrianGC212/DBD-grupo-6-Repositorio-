package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.HistorialDto; // Using your DTO name: HistorialDto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService { 

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<HistorialDto> getHistorialEquipos() { 
        String sql = "SELECT " +
                "rep.COD_REPORTE_EQUIPOS AS \"codigoReporte\", " +
                "CONCAT(e.COD_EQUIPOS, ' - ', e.Nombre_equipo) AS \"equipo\", " +
                "est_eq.Descripcion AS \"estado\", " +
                "CASE " +
                "    WHEN rep.ID_PLANIFICACIONES_ASIGNACION IS NOT NULL THEN " +
                "        CASE " +
                "            WHEN hca.ID_Area_Anterior IS NOT NULL AND hca.ID_Area_Actual IS NOT NULL THEN " +
                "                CONCAT(a_ant.Nombre_del_area, ' -> ', a_act.Nombre_del_area) " +
                "            ELSE '' " +
                "        END " +
                "    ELSE '' " +
                "END AS \"cambioArea\", " + 
                "CASE " +
                "    WHEN rep.ID_PLANIFICACIONES_ASIGNACION IS NOT NULL THEN pa.Fecha_de_asignacion " +
                "    ELSE pm.Fecha_de_inicio " +
                "END AS \"fechaInicio\", " + 
                "CASE " +
                "    WHEN rep.ID_PLANIFICACIONES_ASIGNACION IS NOT NULL THEN pa.Fecha_de_vencimiento " +
                "    WHEN est_eq.Descripcion = 'Fuera de servicio' THEN NULL " +
                "    ELSE pm.Fecha_de_fin " +
                "END AS \"fechaFin\", " + 
                "CASE " +
                "    WHEN rep.ID_PROG_MANTENIMIENTOS IS NOT NULL AND est_eq.Descripcion <> 'Fuera de servicio' THEN ms.COD_MAQUINAS_SUSTITUTAS " +
                "    ELSE '' " +
                "END AS \"maquinaSustituta\", " + 
                "CASE " +
                "    WHEN rep.ID_PLANIFICACIONES_ASIGNACION IS NOT NULL THEN pa.Descripcion_de_tarea " +
                "    ELSE '' " +
                "END AS \"detalle\" " +
                "FROM REPORTE_EQUIPOS rep " +
                "JOIN EQUIPOS e ON rep.ID_EQUIPOS = e.ID_EQUIPOS " +
                "LEFT JOIN Estado_Equipo est_eq ON e.ID_Estado_equipo = est_eq.ID_Estado_equipo " +
                "LEFT JOIN Historial_Cambios_Area hca ON e.ID_EQUIPOS = hca.ID_EQUIPOS " +
                "LEFT JOIN Area a_ant ON hca.ID_Area_Anterior = a_ant.ID_Area " +
                "LEFT JOIN Area a_act ON hca.ID_Area_Actual = a_act.ID_Area " +
                "LEFT JOIN PLANIFICACIONES_ASIGNACION pa ON rep.ID_PLANIFICACIONES_ASIGNACION = pa.ID_PLANIFICACIONES_ASIGNACION " +
                "LEFT JOIN PROG_MANTENIMIENTOS pm ON rep.ID_PROG_MANTENIMIENTOS = pm.ID_PROG_MANTENIMIENTOS " +
                "LEFT JOIN Estado_Mantenimiento em ON pm.ID_Estado_mantenimiento = em.ID_Estado_mantenimiento " +
                "LEFT JOIN MAQUINAS_SUSTITUTAS ms ON pm.ID_MAQUINAS_SUSTITUTAS = ms.ID_MAQUINAS_SUSTITUTAS " +
                "LEFT JOIN Mantenimiento_detalle md ON pm.ID_PROG_MANTENIMIENTOS = md.ID_PROG_MANTENIMIENTOS " +
                "ORDER BY \"fechaInicio\" NULLS LAST, \"codigoReporte\"";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            HistorialDto dto = new HistorialDto();
            dto.setCodigoReporte(rs.getString("codigoReporte"));
            dto.setEquipo(rs.getString("equipo"));
            dto.setEstado(rs.getString("estado"));
            dto.setCambioArea(rs.getString("cambioArea"));
            dto.setFechaInicio(rs.getString("fechaInicio")); // Changed to getString()
            dto.setFechaFin(rs.getString("fechaFin"));     // Changed to getString()
            dto.setMaquinaSustituta(rs.getString("maquinaSustituta"));
            dto.setDetalle(rs.getString("detalle"));
            return dto;
        });
    }
}