package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.ProgEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.format.DateTimeParseException;
import java.time.LocalDateTime; 


@Service
public class ProgEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     
     *
     * @param dto 
     * @return 
     */
    public String programarAsignacionEquipo(ProgEquipoDto dto) {
        try {
            Integer idEquipo = dto.getIdEquipo();
            String nuevaArea = dto.getIdArea();

            
            String sqlEstado = "SELECT COUNT(1) FROM EQUIPOS WHERE ID_EQUIPOS = ? AND ID_Estado_equipo = 'OPE'";
            int equipoCount = jdbcTemplate.queryForObject(sqlEstado, Integer.class, idEquipo);

            if (equipoCount == 0) {
                return "Error al registrar la programación del equipo: El equipo con ID " + idEquipo + " no está operativo o no existe.";
            }

            
            String sqlGetOldArea = "SELECT MAX(ID_Area) FROM PLANIFICACIONES_ASIGNACION WHERE ID_EQUIPOS = ?";
            String areaAnterior = null;
            try {
               
                areaAnterior = jdbcTemplate.queryForObject(sqlGetOldArea, String.class, idEquipo);
            } catch (EmptyResultDataAccessException e) {
               
                System.err.println("Advertencia: No se encontró ID_Area para el equipo con ID " + idEquipo + " (EmptyResultDataAccessException). " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error al obtener el área anterior (mayor ID_Area) para el equipo con ID " + idEquipo + ". Detalle: " + e.getMessage());
            }

           
            Timestamp fechaInicio = Timestamp.valueOf(dto.getFechaInicio());
            Timestamp fechaFin = Timestamp.valueOf(dto.getFechaFin());
   Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now()); // Obtener la fecha y hora actuales

            // Validación: Las fechas de inicio y fin no pueden ser en el pasado
            if (fechaInicio.before(currentTime) || fechaFin.before(currentTime)) {
                return "Error al registrar la programación del equipo: Las fechas de inicio o fin no pueden ser en el pasado.";
            }

            // Validación: La fecha de inicio no puede ser posterior a la fecha de fin
            if (fechaInicio.after(fechaFin)) {
                return "Error al registrar la programación del equipo: La fecha de inicio no puede ser posterior a la fecha de fin.";
            }
            
            String sqlFecha = "SELECT COUNT(1) FROM PLANIFICACIONES_ASIGNACION " +
                                "WHERE ID_EQUIPOS = ? " +
                                "AND ((Fecha_de_asignacion <= ?) AND (Fecha_de_vencimiento >= ?))";

            int count = jdbcTemplate.queryForObject(sqlFecha, Integer.class, idEquipo, fechaFin, fechaInicio);

            if (count > 0) {
                return "Error al registrar la programación del equipo: El equipo ya está asignado en las fechas y horas solicitadas.";
            }

           
            String sqlMaxCodeAsignacion = "SELECT MAX(COD_PLANIFICACIONES_ASIGNACION) FROM PLANIFICACIONES_ASIGNACION";
            String lastCodeAsignacion = null;
            try {
                lastCodeAsignacion = jdbcTemplate.queryForObject(sqlMaxCodeAsignacion, String.class);
            } catch (EmptyResultDataAccessException e) {
                System.out.println("No hay programaciones de asignación previas.");
            }

            String newCodeAsignacion;
            int nextNumberAsignacion = 1;

            if (lastCodeAsignacion != null && lastCodeAsignacion.matches("PA\\d{6}")) {
                try {
                    nextNumberAsignacion = Integer.parseInt(lastCodeAsignacion.substring(2)) + 1;
                } catch (NumberFormatException e) {
                    System.err.println("Advertencia: El último código de asignación '" + lastCodeAsignacion + "' no tiene el formato numérico esperado (PA######). Iniciando desde 1. " + e.getMessage());
                }
            } else if (lastCodeAsignacion != null) {
                System.err.println("Advertencia: El último código de asignación '" + lastCodeAsignacion + "' no coincide con el patrón PA######. Iniciando desde 1.");
            }
            newCodeAsignacion = "PA" + String.format("%06d", nextNumberAsignacion);

         
            String sqlInsertAsignacion = "INSERT INTO PLANIFICACIONES_ASIGNACION (COD_PLANIFICACIONES_ASIGNACION, Fecha_de_asignacion, Fecha_de_vencimiento, Descripcion_de_tarea, " +
                                        "ID_Area, ID_EQUIPOS, ID_Empleado_Registra, ID_Empleado_Solicita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsertAsignacion, newCodeAsignacion, fechaInicio, fechaFin, dto.getDescripcionTarea(),
                                dto.getIdArea(), idEquipo, dto.getIdEmpleadoRegistra(), dto.getIdEmpleadoSolicita());

           
            if (areaAnterior != null && !areaAnterior.equals(nuevaArea)) {
                String sqlGetIdPlanificacion = "SELECT ID_PLANIFICACIONES_ASIGNACION FROM PLANIFICACIONES_ASIGNACION WHERE COD_PLANIFICACIONES_ASIGNACION = ?";
                Integer idPlanificacionAsignacion = null;
                try {
                    idPlanificacionAsignacion = jdbcTemplate.queryForObject(sqlGetIdPlanificacion, Integer.class, newCodeAsignacion);
                } catch (EmptyResultDataAccessException e) {
                    System.err.println("Error: No se encontró la planificación recién creada con código " + newCodeAsignacion + " en la base de datos. Detalle: " + e.getMessage());
                    return "Error crítico: No se pudo verificar la planificación recién creada para registrar el historial de cambio de área.";
                } catch (Exception e) {
                    System.err.println("Error inesperado al obtener ID_PLANIFICACIONES_ASIGNACION para el código " + newCodeAsignacion + ". Detalle: " + e.getMessage());
                    return "Error inesperado al obtener ID_PLANIFICACIONES_ASIGNACION para registrar el historial de cambio de área.";
                }

                if (idPlanificacionAsignacion != null) {
                    // Generamos un nuevo código para Historial_Cambios_Area
                    String sqlMaxCodeCambio = "SELECT MAX(COD_Cambio) FROM Historial_Cambios_Area";
                    String lastCodeCambio = null;
                    try {
                        lastCodeCambio = jdbcTemplate.queryForObject(sqlMaxCodeCambio, String.class);
                    } catch (EmptyResultDataAccessException e) {
                        System.out.println("No hay cambios de área previos registrados.");
                    }

                    String newCodeCambio;
                    int nextNumberCambio = 1;

                    if (lastCodeCambio != null && lastCodeCambio.matches("CA\\d{6}")) {
                        try {
                            nextNumberCambio = Integer.parseInt(lastCodeCambio.substring(2)) + 1;
                        } catch (NumberFormatException e) {
                            System.err.println("Advertencia: El último código de cambio '" + lastCodeCambio + "' no tiene el formato numérico esperado (CA######). Iniciando desde 1. " + e.getMessage());
                        }
                    } else if (lastCodeCambio != null) {
                        System.err.println("Advertencia: El último código de cambio '" + lastCodeCambio + "' no coincide con el patrón CA######. Iniciando desde 1.");
                    }
                    newCodeCambio = "CA" + String.format("%06d", nextNumberCambio);

                   
                    String sqlInsertHistorial = "INSERT INTO Historial_Cambios_Area (COD_Cambio, ID_EQUIPOS, ID_PLANIFICACIONES_ASIGNACION, ID_Area_Anterior, ID_Area_Actual) VALUES (?, ?, ?, ?, ?)";
                    jdbcTemplate.update(sqlInsertHistorial, newCodeCambio, idEquipo, idPlanificacionAsignacion, areaAnterior, nuevaArea);
                    return "Programación del equipo registrada exitosamente con código: " + newCodeAsignacion + ". Se registró cambio de área del equipo de '" + areaAnterior + "' a '" + nuevaArea + "' con código: " + newCodeCambio;
                } else {
                    return "Error al obtener ID_PLANIFICACIONES_ASIGNACION para registrar el historial de cambio de área. Posiblemente no se encontró la planificación recién creada.";
                }
            }

            return "Programación del equipo registrada exitosamente con código: " + newCodeAsignacion;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return "Error en el formato de fecha/hora proporcionado. Asegúrese de usar el formato: YYYY-MM-DDTHH:MM:SS. Detalle: " + e.getMessage();
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return "Error de datos: No se encontró un registro esperado o el resultado está vacío. Detalle: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error inesperado al registrar la programación del equipo: " + e.getMessage();
        }
    }
}
