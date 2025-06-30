package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarReporteInventarioDto;
import logistica_agrovision.log_agrov.Service.InventarioService.VisualizarReporteInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reporte-inventario") // Endpoint base para reporte de inventario
public class VisualizarReporteInventarioController {
    
    @Autowired
    private VisualizarReporteInventarioService visualizarReporteInventarioService;

    @GetMapping("/visualizar") // Endpoint para obtener el reporte de inventario
    public List<VisualizarReporteInventarioDto> obtenerReporteInventario() {
        return visualizarReporteInventarioService.obtenerReporteInventario();
    }

    @GetMapping("/buscar/{Observacion}")
    public List<VisualizarReporteInventarioDto> obtenerReportePorObservacion(@PathVariable String Observacion) {
        return visualizarReporteInventarioService.obtenerReportePorObservacion(Observacion);
    }
}
