package logistica_agrovision.log_agrov.Controller.PedidosController;


import logistica_agrovision.log_agrov.Dto.PedidosDto.RegistrarEmpaqueDto;
import logistica_agrovision.log_agrov.Models.Lote;
import logistica_agrovision.log_agrov.Models.Picking;
import logistica_agrovision.log_agrov.Models.ProductoPicking;
import logistica_agrovision.log_agrov.Service.PedidosService.PreparacionPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    PreparacionPedidosService preparacionPedidosService;

    @GetMapping("/getPickings")
    public List<Picking> getPickings(@RequestParam String param) {
        return preparacionPedidosService.getPickings(param);
    }

    @GetMapping("/getProductosPicking")
    public List<ProductoPicking> getProductosPicking() {
        return preparacionPedidosService.getProductosPicking();
    }

    @GetMapping("/getLotes")
    public List<Lote> getLotes(@RequestParam String param) {
        return preparacionPedidosService.getLotes(param);
    }

    @PostMapping("/nuevoEmpaque")
    public void nuevoEmpaque(@RequestBody RegistrarEmpaqueDto dto) {
        preparacionPedidosService.registrarEmpaque(dto);
    }
}
