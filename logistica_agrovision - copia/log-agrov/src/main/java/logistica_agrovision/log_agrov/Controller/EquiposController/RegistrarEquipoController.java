package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.RegistrarEquipoService;
import logistica_agrovision.log_agrov.Dto.EquiposDto.RegistrarEquipoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
public class RegistrarEquipoController {

    @Autowired
    private RegistrarEquipoService registrarEquipoService;

    @PostMapping("/registrar")  // El endpoint para registrar el equipo
    public String registrarEquipo(@RequestBody RegistrarEquipoDto registrarEquipoDto) {
        boolean success = registrarEquipoService.registrarEquipo(registrarEquipoDto);
        if (success) {
            return "El equipo ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar el equipo.";
        }
    }
}
