package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Dto.RegistrarMaquinaSDto;
import logistica_agrovision.log_agrov.Service.RegistrarMaquinaSService;
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
