package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.VisMantenimientoService;
import logistica_agrovision.log_agrov.Dto.EquiposDto.VisMantenimientoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisMantenimientoController {

    @Autowired
    private VisMantenimientoService visMantenimientoService;

    // Endpoint para obtener los mantenimientos
    @GetMapping("/api/mantenimiento/obtener")
    public List<VisMantenimientoDto> obtenerMantenimientos() {
        return visMantenimientoService.obtenerMantenimientos();
    }
}
