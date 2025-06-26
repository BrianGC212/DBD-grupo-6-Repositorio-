package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.ProgEquipoDto;
import logistica_agrovision.log_agrov.Models.Area;
import logistica_agrovision.log_agrov.Models.Empleado;
import logistica_agrovision.log_agrov.Models.Equipo;
import logistica_agrovision.log_agrov.Service.EquiposService.ProgEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/maquinas")
public class ProgEquipoController {

    @Autowired
    private ProgEquipoService progEquipoService;

  @PostMapping("/programarAsignacion")
    public ResponseEntity<?> programarAsignacion(@RequestBody ProgEquipoDto dto) {
        try {
            String mensajeExito = progEquipoService.programarAsignacionEquipo(dto);
            // Si el servicio no lanzó excepción, la operación fue exitosa.
            // Devolvemos 200 OK y un JSON con el mensaje en la clave "message".
            return ResponseEntity.ok(Map.of("message", mensajeExito));

        } catch (IllegalArgumentException e) {
            // Captura excepciones de validación (ej. campos vacíos) que lanza el servicio.
            // Devuelve un 400 Bad Request y un JSON con el mensaje de la excepción en la clave "message".
            System.err.println("Error de validación al programar asignación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) // Código 400
                                 .body(Map.of("message", e.getMessage())); // Mensaje de error para el frontend
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada (errores internos del servidor, DB, etc.).
            // Devuelve un 500 Internal Server Error y un mensaje genérico.
            System.err.println("Error interno del servidor al programar asignación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // Código 500
                                 .body(Map.of("message", "Ocurrió un error inesperado al procesar la solicitud.")); // Mensaje genérico
        }
    }
    @GetMapping("/listarEmpleados")
    public List<Empleado> listarEmpleados() {
        return progEquipoService.obtenerEmpleados();
    }

    @GetMapping("/listarAreas")
    public List<Area> listarAreas() {
        return progEquipoService.getAreas();
    }

    @GetMapping("/listarEquipos")
    public List<Equipo> listarEquipos() {
        return progEquipoService.getEquipos();
    }
}