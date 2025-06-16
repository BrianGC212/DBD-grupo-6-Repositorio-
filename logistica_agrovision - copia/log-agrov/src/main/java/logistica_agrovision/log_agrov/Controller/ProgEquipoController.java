package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Dto.ProgEquipoDto;
import logistica_agrovision.log_agrov.Service.ProgEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquinas")
public class ProgEquipoController {

    @Autowired
    private ProgEquipoService progEquipoService;

    @PostMapping("/programarAsignacion")
    public ResponseEntity<String> programarAsignacion(@RequestBody ProgEquipoDto dto) {
        String mensaje = progEquipoService.programarAsignacionEquipo(dto);
        return ResponseEntity.ok(mensaje); // Devolver el mensaje con el resultado
    }
}