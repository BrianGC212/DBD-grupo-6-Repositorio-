package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.DeleteProgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/maquinas")
public class DeleteProgController {

    @Autowired
    private DeleteProgService deleteProgService;

    // Eliminar una programación usando el código de planificación
    @DeleteMapping("/programar/{codigo}")
    public String deleteProgramacion(@PathVariable String codigo) {
        return deleteProgService.deleteProgramacion(codigo);
    }
}

