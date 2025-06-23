package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.MantenimientoDTO;
import logistica_agrovision.log_agrov.Service.EquiposService.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    // Fase 1: Registrar el mantenimiento del equipo
    @PostMapping("/registrar")
    @ResponseBody
    public String registrarMantenimiento(@RequestBody MantenimientoDTO mantenimientoDTO) {
        return mantenimientoService.registrarMantenimiento(mantenimientoDTO);
    }

   
}
