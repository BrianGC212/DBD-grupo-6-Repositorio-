package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.ProgEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.format.DateTimeParseException;
// No se necesita List aquí ya que queryForObject será suficiente con MAX() y UNIQUE.
// import java.util.List;

@Service
public class ProgEquipoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Programa la asignación de un equipo, verificando su estado operativo
     * y la disponibilidad de fechas y horas antes de registrar la asignación.
     * También registra el cambio de área del equipo en el historial si la planificación
     * implica un cambio de área.
     *
     * @param dto Objeto ProgEquipoDto que contiene los detalles de la programación,
     * incluyendo fecha y hora de asignación/vencimiento.
     * @return Un mensaje de éxito o un mensaje de error detallado.
     */
    public String programarAsignacionEquipo(ProgEquipoDto dto) {
        try {
            Integer idEquipo = dto.getIdEquipo();
            String nuevaArea = dto.getIdArea();

            // 1. Verificamos que el equipo exista y esté operativo
            String sqlEstado = "SELECT COUNT(1) FROM EQUIPOS WHERE ID_EQUIPOS = ? AND ID_Estado_equipo = 'OPE'";
            int equipoCount = jdbcTemplate.queryForObject(sqlEstado, Integer.class, idEquipo);

            if (equipoCount == 0) {
                return "Error al registrar la programación del equipo: El equipo con ID " + idEquipo + " no está operativo o no existe.";
            }

            // 2. Obtenemos el área actual (mayor ID_Area) del equipo antes de la posible asignación
            // Usamos MAX(ID_Area) para asegurar que siempre se obtenga un único resultado (el mayor)
            String sqlGetOldArea = "SELECT MAX(ID_Area) FROM PLANIFICACIONES_ASIGNACION WHERE ID_EQUIPOS = ?";
            String areaAnterior = null;
            try {
                // queryForObject es seguro aquí porque MAX() siempre devuelve un solo resultado (o null si no hay filas)
                areaAnterior = jdbcTemplate.queryForObject(sqlGetOldArea, String.class, idEquipo);
            } catch (EmptyResultDataAccessException e) {
                // Esto podría ocurrir si el equipo existe pero no tiene un ID_Area asociado (caso inusual si equipoCount > 0)
                System.err.println("Advertencia: No se encontró ID_Area para el equipo con ID " + idEquipo + " (EmptyResultDataAccessException). " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error al obtener el área anterior (mayor ID_Area) para el equipo con ID " + idEquipo + ". Detalle: " + e.getMessage());
            }

            // Convertimos las fechas/horas del DTO (LocalDateTime) a java.sql.Timestamp para la base de datos
            Timestamp fechaInicio = Timestamp.valueOf(dto.getFechaInicio());
            Timestamp fechaFin = Timestamp.valueOf(dto.getFechaFin());

            // 3. Verificamos si el equipo ya está asignado en las fechas y horas solicitadas
            // Usamos la lógica de superposición de rangos: (InicioExistente <= FinSolicitada) AND (FinExistente >= InicioSolicitada)
            String sqlFecha = "SELECT COUNT(1) FROM PLANIFICACIONES_ASIGNACION " +
                                "WHERE ID_EQUIPOS = ? " +
                                "AND ((Fecha_de_asignacion <= ?) AND (Fecha_de_vencimiento >= ?))";

            int count = jdbcTemplate.queryForObject(sqlFecha, Integer.class, idEquipo, fechaFin, fechaInicio);

            if (count > 0) {
                return "Error al registrar la programación del equipo: El equipo ya está asignado en las fechas y horas solicitadas.";
            }

            // 4. Obtenemos el último código de asignación y generamos uno nuevo para PLANIFICACIONES_ASIGNACION
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

            // 5. Registramos la programación del equipo en la base de datos
            String sqlInsertAsignacion = "INSERT INTO PLANIFICACIONES_ASIGNACION (COD_PLANIFICACIONES_ASIGNACION, Fecha_de_asignacion, Fecha_de_vencimiento, Descripcion_de_tarea, " +
                                        "ID_Area, ID_EQUIPOS, ID_Empleado_Registra, ID_Empleado_Solicita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsertAsignacion, newCodeAsignacion, fechaInicio, fechaFin, dto.getDescripcionTarea(),
                                dto.getIdArea(), idEquipo, dto.getIdEmpleadoRegistra(), dto.getIdEmpleadoSolicita());

            // 6. Si el equipo cambia de área, registramos el cambio en Historial_Cambios_Area
            // La condición areaAnterior != null && !areaAnterior.equals(nuevaArea) compara las strings, incluyendo nulls.
            if (areaAnterior != null && !areaAnterior.equals(nuevaArea)) {
                // Obtenemos el ID_PLANIFICACIONES_ASIGNACION recién insertado
                // Se espera un único resultado debido a la restricción UNIQUE en COD_PLANIFICACIONES_ASIGNACION
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

                    // Insertamos el registro en Historial_Cambios_Area
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
