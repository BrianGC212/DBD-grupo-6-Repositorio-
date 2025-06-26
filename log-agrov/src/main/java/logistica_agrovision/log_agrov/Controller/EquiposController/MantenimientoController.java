package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.MantenimientoDTO;
import logistica_agrovision.log_agrov.Models.Estado;
import logistica_agrovision.log_agrov.Models.MaquinaSustituta;
import logistica_agrovision.log_agrov.Service.EquiposService.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    // Fase 1: Registrar el mantenimiento del equipo
    @PostMapping("/registrar")
    @ResponseBody
    public String registrarMantenimiento(@RequestBody MantenimientoDTO mantenimientoDTO) {
        return mantenimientoService.registrarMantenimiento(mantenimientoDTO);
    }

    @GetMapping("/getEstadosEquipo")
    public List<Estado> getEstadosEquipo() {
        return mantenimientoService.getEstadosEquipo();
    }

    @GetMapping("/getEstadosMantenimiento")
    public List<Estado> getEstadosMantenimiento() {
        return mantenimientoService.getEstadosMantenimiento();
    }

   @GetMapping("/getMaquinasSustitutas")
    public List<MaquinaSustituta> getMaquinasSustitutas() {
        return mantenimientoService.getMaquinasSustitutas();
   }
}
