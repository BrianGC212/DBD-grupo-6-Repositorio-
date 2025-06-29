package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarProcesoDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.VisualizarProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class VisualizarProcesoController {

    @Autowired
    private VisualizarProcesoService visualizarProcesoService;

    @GetMapping("/visualizarProcesos")
    public List<VisualizarProcesoDto> obtenerProcesos() {
        return visualizarProcesoService.obtenerProcesos();
    }
}

