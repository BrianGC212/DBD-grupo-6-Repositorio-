package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.ActualizarEquipoDto;
import logistica_agrovision.log_agrov.Service.EquiposService.ActualizarEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
public class ActualizarEquipoController {

    @Autowired
    private ActualizarEquipoService actualizarEquipoService;

    
    @PutMapping("/actualizar")
    public String actualizarEstadoEquipo(@RequestBody ActualizarEquipoDto actualizaEquipoDto) {
        return actualizarEquipoService.actualizarEstadoEquipo(actualizaEquipoDto);
    }
}
