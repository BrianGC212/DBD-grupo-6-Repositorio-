package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroControlCalidadDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.RegistroControlCalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/control-calidad")
public class RegistroControlCalidadController {

    @Autowired
    private RegistroControlCalidadService registroControlCalidadService;

    @GetMapping("/recepcion/{codRecepcion}")
    public ResponseEntity<Map<String, Object>> obtenerCodRecepcion(@PathVariable String codRecepcion) {
        Map<String, Object> data = registroControlCalidadService.obtenerCodRecepcion(codRecepcion);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/aprobar")
    public ResponseEntity<String> aprobarControlCalidad(@RequestBody RegistroControlCalidadDto dto) {
        registroControlCalidadService.registrarControlCalidadAprobado(dto);
        return ResponseEntity.ok("Control de calidad registrado como Aprobado.");
    }

    @PostMapping("/observar")
    public ResponseEntity<String> observarControlCalidad(@RequestBody RegistroControlCalidadDto dto) {
        if ((dto.getObservacionesLote() == null || dto.getObservacionesLote().trim().isEmpty()) ||
            (dto.getObservacionesEmpaque() == null || dto.getObservacionesEmpaque().trim().isEmpty())) {
            return ResponseEntity.badRequest().body("Las observaciones del lote y empaque son obligatorias en estado Observado.");
        }

        registroControlCalidadService.registrarControlCalidadObservado(dto);
        return ResponseEntity.ok("Control de calidad registrado como Observado.");
    }
}
