package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.VisualizacionControlCalidadDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.VisualizacionControlCalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/control-calidad")
public class VisualizacionControlCalidadController {

    @Autowired
    private VisualizacionControlCalidadService service;

    @GetMapping("/observados")
    public List<VisualizacionControlCalidadDto> obtenerControlesObservados() {
        return service.listarObservados();
    }

    @GetMapping("/observados/buscar")
    public List<VisualizacionControlCalidadDto> buscarPorNombreProducto(@RequestParam("nombre") String nombre) {
        return service.buscarPorNombreProducto(nombre);
    }
}
