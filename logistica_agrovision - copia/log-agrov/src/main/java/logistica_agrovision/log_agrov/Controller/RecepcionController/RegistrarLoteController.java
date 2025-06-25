package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistrarLoteDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.RegistrarLoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lotes")
public class RegistrarLoteController {

    @Autowired
    private RegistrarLoteService registrarLoteService;

    @PostMapping("/registrar")
    public String registrarLote(@RequestBody RegistrarLoteDto dto) {
        boolean success = registrarLoteService.registrarLote(dto);
        if (success) {
            return "El lote ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar el lote.";
        }
    }
}
