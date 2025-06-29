package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarIncidenciaDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.VisualizarIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class VisualizarIncidenciaController {

    @Autowired
    private VisualizarIncidenciaService visualizarIncidenciaService;

    @GetMapping("/visualizarIncidencias")
    public List<VisualizarIncidenciaDto> obtenerIncidencias() {
        return visualizarIncidenciaService.obtenerIncidencias();
    }
}