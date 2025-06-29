package logistica_agrovision.log_agrov.Service.TrazabilidadService;


import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.RegistrarIncidenciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RegistrarIncidenciaService {
    private static final Logger logger = LoggerFactory.getLogger(RegistrarIncidenciaService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String generarCodigoIncidencia() {
        String sql = "SELECT MAX(cod_incidencias) FROM incidencias";
        String ultimoCodigo = jdbcTemplate.queryForObject(sql, String.class);
        
        if (ultimoCodigo == null) {
            return "INC00001";
        }
        
        try {
            String numeroStr = ultimoCodigo.substring(3);
            int numero = Integer.parseInt(numeroStr) + 1;
            return String.format("INC%05d", numero);
        } catch (Exception e) {
            return "INC00001";
        }
    }

    public boolean registrarIncidencia(RegistrarIncidenciaDto dto) {
    // Validaciones básicas
    if (dto.getCausa() == null || dto.getCausa().trim().isEmpty()) {
        throw new IllegalArgumentException("La causa es requerida");
    }
    if (dto.getTipoIncidencia() == null || dto.getTipoIncidencia().trim().isEmpty()) {
        throw new IllegalArgumentException("El tipo de incidencia es requerido");
    }

    // Formatear fechas correctamente
    try {
        dto.setFechaRegistrada(new java.sql.Date(System.currentTimeMillis()));
       dto.setHora(LocalTime.now());
        
        if (dto.getFechaResolucion() != null) {
            // Convertir java.util.Date a java.sql.Date si es necesario
            if (dto.getFechaResolucion() instanceof java.util.Date) {
                dto.setFechaResolucion(new java.sql.Date(dto.getFechaResolucion().getTime()));
            }
        }
    } catch (Exception e) {
        throw new IllegalArgumentException("Formato de fecha inválido");
    }

    // Valores por defecto
    dto.setEstado(dto.getEstado() != null ? dto.getEstado() : "Pendiente");
    dto.setObservaciones(dto.getObservaciones() != null ? dto.getObservaciones() : "Ninguna");
    dto.setEvidencias(dto.getEvidencias() != null ? dto.getEvidencias() : "Ninguna");

    // Generar código
    dto.setCodIncidencias(generarCodigoIncidencia());

    String sql = """
        INSERT INTO incidencias (
            cod_incidencias, causa, tipo_incidencia, estado,
            fecha_registrada, hora, observaciones, evidencias,
            fecha_resolucion, id_empleado, id_procesos
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    try {
        int rows = jdbcTemplate.update(sql,
            dto.getCodIncidencias(),
            dto.getCausa(),
            dto.getTipoIncidencia(),
            dto.getEstado(),
            dto.getFechaRegistrada(),
            dto.getHora(),
            dto.getObservaciones(),
            dto.getEvidencias(),
            dto.getFechaResolucion(),
            dto.getIdEmpleado() != null ? dto.getIdEmpleado() : 1,
            dto.getIdProcesos() != null ? dto.getIdProcesos() : 1
        );
        return rows > 0;
    } catch (DataAccessException e) {
        logger.error("Error al registrar incidencia", e);
        throw new RuntimeException("Error de base de datos: " + e.getMostSpecificCause().getMessage());
    }
}
} 