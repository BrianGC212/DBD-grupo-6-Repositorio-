package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.VisMantenimientoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class VisMantenimientoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VisMantenimientoDto> obtenerMantenimientos() {
        String query = "SELECT " +
                "pm.COD_PROG_MANTENIMIENTOS AS codigo_mantenimiento, " +
                "eq.Nombre_equipo AS equipo, " +
                "pm.Empresa_encargada, " +
                "em.Descripcion AS tipo_servicio, " +
                "pm.Fecha_de_inicio AS fecha_entrega_a_empresa, " +
                "pm.Fecha_de_fin AS fecha_entrega_de_vuelta, " +
                "ms.COD_MAQUINAS_SUSTITUTAS AS maquina_sustituta, " +
                "ee.Descripcion AS estado_equipo " +
                "FROM " +
                "PROG_MANTENIMIENTOS pm " +
                "JOIN EQUIPOS eq ON pm.ID_EQUIPOS = eq.ID_EQUIPOS " +
                "LEFT JOIN Estado_Mantenimiento em ON pm.ID_Estado_mantenimiento = em.ID_Estado_mantenimiento " +
                "LEFT JOIN Estado_Equipo ee ON eq.ID_Estado_equipo = ee.ID_Estado_equipo " +
                "LEFT JOIN MAQUINAS_SUSTITUTAS ms ON pm.ID_MAQUINAS_SUSTITUTAS = ms.ID_MAQUINAS_SUSTITUTAS " +
                "ORDER BY pm.COD_PROG_MANTENIMIENTOS";


        RowMapper<VisMantenimientoDto> rowMapper = (rs, rowNum) -> {
            VisMantenimientoDto dto = new VisMantenimientoDto();
            dto.setCodigoMantenimiento(rs.getString("codigo_mantenimiento"));
            dto.setEquipo(rs.getString("equipo"));
            dto.setEmpresaEncargada(rs.getString("Empresa_encargada"));
            dto.setTipoServicio(rs.getString("tipo_servicio"));
            dto.setFechaEntregaAEmpresa(rs.getString("fecha_entrega_a_empresa"));
            dto.setFechaEntregaDeVuelta(rs.getString("fecha_entrega_de_vuelta"));
            dto.setMaquinaSustituta(rs.getString("maquina_sustituta"));
            dto.setEstadoEquipo(rs.getString("estado_equipo"));
            return dto;
        };

        
        return jdbcTemplate.query(query, rowMapper);
    }
}
