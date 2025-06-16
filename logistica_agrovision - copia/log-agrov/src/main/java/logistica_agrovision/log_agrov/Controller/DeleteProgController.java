package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Service.DeleteProgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

