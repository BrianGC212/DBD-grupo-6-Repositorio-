package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroRecepcionDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.RegistroRecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recepcion")
public class RegistroRecepcionController {

    @Autowired
    private RegistroRecepcionService registroRecepcionService;

    @GetMapping("/lote/{idLote}")
    public ResponseEntity<Map<String, Object>> obtenerDatosLote(@PathVariable int idLote) {
        Map<String, Object> datos = registroRecepcionService.obtenerDatosDelLote(idLote);
        return ResponseEntity.ok(datos);
    }

    @PostMapping("/aprobar")
    public ResponseEntity<String> aprobarRecepcion(@RequestBody RegistroRecepcionDto dto) {
        registroRecepcionService.registrarRecepcionAprobada(dto.getIdLote(), dto.getCantidadRecibida());
        return ResponseEntity.ok("Recepción registrada como Aprobada.");
    }

    @PostMapping("/observar")
    public ResponseEntity<String> observarRecepcion(@RequestBody RegistroRecepcionDto dto) {
        if (dto.getObservaciones() == null || dto.getObservaciones().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La observación es obligatoria para un lote observado.");
        }
        registroRecepcionService.registrarRecepcionObservada(dto.getIdLote(), dto.getCantidadRecibida(), dto.getObservaciones());
        return ResponseEntity.ok("Recepción registrada como Observada.");
    }
}
