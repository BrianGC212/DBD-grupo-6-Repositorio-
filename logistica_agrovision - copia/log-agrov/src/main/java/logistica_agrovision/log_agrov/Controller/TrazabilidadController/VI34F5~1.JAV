package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarReporteDetalleTrazabilidadDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.VisualizarReporteDetalleTrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class VisualizarReporteDetalleTrazabilidadController {

    @Autowired
    private VisualizarReporteDetalleTrazabilidadService service;

    @GetMapping("/reporteDetalleTrazabilidad/{codReporte}")
    public Optional<VisualizarReporteDetalleTrazabilidadDto> obtenerReporte(@PathVariable String codReporte) {
        return service.obtenerPorCodigo(codReporte);
    }
}