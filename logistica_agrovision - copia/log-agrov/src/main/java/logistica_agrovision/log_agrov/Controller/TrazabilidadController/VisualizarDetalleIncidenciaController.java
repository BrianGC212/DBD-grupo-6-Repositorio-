package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.VisualizarDetalleIncidenciaDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.VisualizarDetalleIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class VisualizarDetalleIncidenciaController {

    @Autowired
    private VisualizarDetalleIncidenciaService service;

    @GetMapping("/detalleIncidencia/{codIncidencia}")
    public Optional<VisualizarDetalleIncidenciaDto> obtenerPorCodigo(@PathVariable String codIncidencia) {
        return service.obtenerPorCodigo(codIncidencia);
    }
}


