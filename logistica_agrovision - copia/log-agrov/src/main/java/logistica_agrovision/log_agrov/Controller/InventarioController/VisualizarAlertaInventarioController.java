package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarAlertaInventarioDto;
import logistica_agrovision.log_agrov.Service.InventarioService.VisualizarAlertaInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alertas-inventario")
public class VisualizarAlertaInventarioController {
    
    @Autowired
    private VisualizarAlertaInventarioService visualizarAlertaInventarioService;

    @GetMapping("/visualizar") // Endpoint para obtener alertas de inventario
    public List<VisualizarAlertaInventarioDto> obtenerAlertasInventario() {
        return visualizarAlertaInventarioService.obtenerAlertasInventario();
    }
}
