package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarMovInventarioDto;
import logistica_agrovision.log_agrov.Service.InventarioService.VisualizarMovInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movimientos-inventario")
public class VisualizarMovInventarioController {

    @Autowired
    private VisualizarMovInventarioService visualizarMovInventarioService;

    @GetMapping("/visualizar") // Endpoint para obtener movimientos de inventario
    public List<VisualizarMovInventarioDto> obtenerMovimientosInventario() {
        return visualizarMovInventarioService.obtenerMovInventario();
    }

    @GetMapping("/buscar/{codLote}")
    public List<VisualizarMovInventarioDto> obtenerMovimientosPorLote(@PathVariable String codLote) {
        return visualizarMovInventarioService.obtenerMovInventarioPorLote(codLote);
    }
}
