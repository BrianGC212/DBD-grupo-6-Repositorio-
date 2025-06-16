package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Dto.ActualizarEquipoDto;
import logistica_agrovision.log_agrov.Service.ActualizarEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
public class ActualizarEquipoController {

    @Autowired
    private ActualizarEquipoService actualizarEquipoService;

    // Endpoint para actualizar el estado de un equipo
    @PutMapping("/actualizar")
    public String actualizarEstadoEquipo(@RequestBody ActualizarEquipoDto actualizaEquipoDto) {
        return actualizarEquipoService.actualizarEstadoEquipo(actualizaEquipoDto);
    }
}
