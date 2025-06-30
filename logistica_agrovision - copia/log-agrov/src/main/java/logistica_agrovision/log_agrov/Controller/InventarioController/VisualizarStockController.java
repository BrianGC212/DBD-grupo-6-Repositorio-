package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.VisualizarStockDto;
import logistica_agrovision.log_agrov.Service.InventarioService.VisualizarStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stock") // Endpoint base para stock
public class VisualizarStockController {
    
    @Autowired
    private VisualizarStockService visualizarStockService;

    @GetMapping("/visualizar") // Endpoint para obtener el stock de productos
    public List<VisualizarStockDto> obtenerStockProductos() {
        return visualizarStockService.obtenerStockProductos();
    }

    @GetMapping("/buscar/{nombreProducto}")
    public List<VisualizarStockDto> obtenerStockPorProducto(@PathVariable String nombreProducto) {
        return visualizarStockService.obtenerStockPorProducto(nombreProducto);
    }

}
