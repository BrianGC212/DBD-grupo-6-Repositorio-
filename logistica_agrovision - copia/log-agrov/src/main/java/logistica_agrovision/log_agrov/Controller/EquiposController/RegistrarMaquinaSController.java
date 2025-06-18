package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.RegistrarMaquinaSDto;
import logistica_agrovision.log_agrov.Service.EquiposService.RegistrarMaquinaSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquinas")
public class RegistrarMaquinaSController {

    @Autowired
    private RegistrarMaquinaSService registrarMaquinaSService;

    @PostMapping("/registrarSustituta")
    public String registrarMaquinaSustituta(@RequestBody RegistrarMaquinaSDto dto) {
        return registrarMaquinaSService.registrarMaquinaSustituta(dto);
    }
}
