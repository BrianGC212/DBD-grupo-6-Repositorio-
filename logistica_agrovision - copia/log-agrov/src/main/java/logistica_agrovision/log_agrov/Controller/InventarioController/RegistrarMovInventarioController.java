package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.RegistrarMovInventarioDto;
import logistica_agrovision.log_agrov.Service.InventarioService.RegistrarMovInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/movimientos-inventario")
public class RegistrarMovInventarioController {
    
    @Autowired
    private RegistrarMovInventarioService registrarMovInventarioService;

    @PostMapping("/registrar")
    public String registrarMovimiento(@RequestBody RegistrarMovInventarioDto dto) {
        boolean success = registrarMovInventarioService.registrarMovimiento(dto);
        if (success) {
            return "El movimiento de inventario ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar el movimiento de inventario.";
        }
    }
}
