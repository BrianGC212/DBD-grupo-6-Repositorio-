package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.MantenimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MantenimientoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para obtener el siguiente código de mantenimiento
    public String generarCodigoMantenimiento() {
        String getCountQuery = "SELECT COUNT(*) FROM PROG_MANTENIMIENTOS";
        int count = jdbcTemplate.queryForObject(getCountQuery, Integer.class);
        return "PM" + String.format("%06d", count + 1); // PM seguido de 6 dígitos (PM000001, PM000002, etc.)
    }

    // Registrar el mantenimiento del equipo
    public String registrarMantenimiento(MantenimientoDTO mantenimientoDTO) {
        // Verificar si el equipo existe en la base de datos
        String equipoCheckQuery = "SELECT COUNT(*) FROM EQUIPOS WHERE ID_equipos = ?";
        int equipoCount = jdbcTemplate.queryForObject(equipoCheckQuery, Integer.class, mantenimientoDTO.getCodigoEquipo());

        if (equipoCount == 0) {
            return "Equipo no encontrado.";
        }

        // If the equipment is being marked as "Operativo"
        if ("OPE".equals(mantenimientoDTO.getIdEstadoEquipo())) {
            // Find the ID of the ongoing maintenance for this equipment
            String getOngoingMaintenanceIdQuery = "SELECT ID_PROG_MANTENIMIENTOS FROM PROG_MANTENIMIENTOS WHERE ID_equipos = ? AND Fecha_de_fin IS NULL ORDER BY Fecha_de_inicio DESC LIMIT 1";
            
            List<String> ongoingMaintenanceIds = jdbcTemplate.queryForList(getOngoingMaintenanceIdQuery, String.class, mantenimientoDTO.getCodigoEquipo());

            if (ongoingMaintenanceIds.isEmpty()) {
                return "No hay un mantenimiento en curso para este equipo que pueda ser finalizado.";
            }

            String ongoingMaintenanceId = ongoingMaintenanceIds.get(0);

            // Update the equipment status to "Operativo"
            String updateEquipoStatusQuery = "UPDATE EQUIPOS SET ID_Estado_equipo = 'OPE' WHERE ID_equipos = ?";
            jdbcTemplate.update(updateEquipoStatusQuery, mantenimientoDTO.getCodigoEquipo());

            // If a substitute machine was used, mark it as "Fuera de servicio"
            if (mantenimientoDTO.getCodigoMaquinaSustituta() != null) {
                String updateSustitutaStatusQuery = "UPDATE MAQUINAS_SUSTITUTAS SET id_estado_equipo = 'FSE' WHERE ID_maquinas_sustitutas = ?";
                jdbcTemplate.update(updateSustitutaStatusQuery, mantenimientoDTO.getCodigoMaquinaSustituta());
            }

            // Register the end date of the maintenance
            String updateMantenimientoQuery = "UPDATE PROG_MANTENIMIENTOS SET Fecha_de_fin = NOW(), ID_Estado_mantenimiento = 'FIN' WHERE ID_PROG_MANTENIMIENTOS = ?";
            jdbcTemplate.update(updateMantenimientoQuery, ongoingMaintenanceId);

            return "El equipo ha sido cambiado a operativo y la máquina sustituta ha sido marcada como fuera de servicio (si aplica).";
        }

        // If the equipment is going into maintenance, register a new maintenance record
        String codigoMantenimiento = generarCodigoMantenimiento();
        mantenimientoDTO.setCodigoMantenimiento(codigoMantenimiento);
        // Note: fechaRegistro is set in DTO, but NOW() is used in SQL for consistency

        String insertMantenimientoQuery = "INSERT INTO PROG_MANTENIMIENTOS " +
                "(COD_PROG_MANTENIMIENTOS, fecha_registro, Fecha_de_inicio, Fecha_de_fin, Empresa_encargada, ID_equipos, ID_Estado_mantenimiento, ID_Empleado_Registra, ID_Empleado_Solicita) " +
                "VALUES (?, NOW(), ?, NULL, ?, ?, ?, ?, ?)"; // Use NOW() for fecha_registro

        jdbcTemplate.update(insertMantenimientoQuery,
                mantenimientoDTO.getCodigoMantenimiento(),    // COD_PROG_MANTENIMIENTOS
                mantenimientoDTO.getFechaInicio(),            // Fecha_de_inicio
                mantenimientoDTO.getEmpresaEncargada(),       // Empresa_encargada
                mantenimientoDTO.getCodigoEquipo(),           // ID_equipos
                mantenimientoDTO.getIdEstadoMantenimiento(),  // ID_Estado_mantenimiento
                mantenimientoDTO.getIdEmpleadoRegistra(),     // ID_Empleado_Registra
                mantenimientoDTO.getIdEmpleadoSolicita());    // ID_Empleado_Solicita

        // Update the equipment status to "MNT" (Mantenimiento)
        String updateEquipoStatusQuery = "UPDATE EQUIPOS SET ID_Estado_equipo = 'MNT' WHERE ID_equipos = ?";
        jdbcTemplate.update(updateEquipoStatusQuery, mantenimientoDTO.getCodigoEquipo());

        return "Mantenimiento registrado correctamente.";
    }
}