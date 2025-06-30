package logistica_agrovision.log_agrov.Service.RecepcionService;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroControlCalidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegistroControlCalidadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> obtenerCodRecepcion(String codRecepcion) {
        String sql = "SELECT r.cod_recepcion FROM Recepcion r WHERE r.cod_recepcion = ?";
        return jdbcTemplate.queryForMap(sql, codRecepcion);
    }

    private String generarCodigoControlCalidad() {
        String sqlCount = "SELECT COUNT(*) FROM Control_de_calidad";
        int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);
        return "QC" + String.format("%06d", count + 1); // Ej: QC000001
    }

    public void registrarControlCalidadAprobado(RegistroControlCalidadDto dto) {
        String codControlCalidad = generarCodigoControlCalidad();

        String sql = "INSERT INTO Control_de_calidad (" +
                "cod_control_calidad, fecha_inspeccion, id_estado_paquete_recepcion, temperatura_producto, " +
                "observaciones_lote, observaciones_empaque, id_estado_control_calidad, id_recepcion, id_empleado) " +
                "VALUES (?, CURRENT_DATE, ?, ?, NULL, NULL, 'A', ?, ?)";

        jdbcTemplate.update(sql, codControlCalidad,
                dto.getIdEstadoPaqueteRecepcion(),
                dto.getTemperaturaProducto(),
                dto.getIdRecepcion(),
                dto.getIdEmpleado());
    }

    public void registrarControlCalidadObservado(RegistroControlCalidadDto dto) {
    try {
        String codControlCalidad = this.generarCodigoControlCalidad();
        String sql = "INSERT INTO Control_de_calidad (cod_control_calidad, fecha_inspeccion, id_estado_paquete_recepcion, temperatura_producto, observaciones_lote, observaciones_empaque, id_estado_control_calidad, id_recepcion, id_empleado) VALUES (?, CURRENT_DATE, ?, ?, ?, ?, 'O', ?, ?)";
        this.jdbcTemplate.update(sql, new Object[]{
            codControlCalidad,
            dto.getIdEstadoPaqueteRecepcion(),
            dto.getTemperaturaProducto(),
            dto.getObservacionesLote(),
            dto.getObservacionesEmpaque(),
            dto.getIdRecepcion(),
            dto.getIdEmpleado()
        });
    } catch (Exception e) {
        e.printStackTrace(); // Muestra el error exacto en la consola
        throw new RuntimeException("Error al registrar control de calidad observado: " + e.getMessage());
    }
}

}
