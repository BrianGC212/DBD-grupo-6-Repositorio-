package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarReporteTrazabilidadDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.VisualizarReporteTrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class VisualizarReporteTrazabilidadController {

    @Autowired
    private VisualizarReporteTrazabilidadService visualizarReporteTrazabilidadService;

    @GetMapping("/reporteTrazabilidad")
    public List<VisualizarReporteTrazabilidadDto> obtenerReporteTrazabilidad() {
        return visualizarReporteTrazabilidadService.obtenerReporteTrazabilidad();
    }
}

