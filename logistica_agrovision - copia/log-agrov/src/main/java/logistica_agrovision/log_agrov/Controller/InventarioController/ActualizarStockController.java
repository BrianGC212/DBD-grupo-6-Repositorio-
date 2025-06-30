package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.ActualizarStockDto;
import logistica_agrovision.log_agrov.Service.InventarioService.ActualizarStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class ActualizarStockController {
    
    @Autowired
    private ActualizarStockService actualizarStockService;

    @PutMapping("/actualizar-stock")
    public String actualizarStock(@RequestBody ActualizarStockDto actualizarStockDto) {
        boolean resultado = actualizarStockService.actualizarStock(actualizarStockDto);
        return resultado ? "Stock actualizado correctamente" : "Error al actualizar el stock";
    }

}
