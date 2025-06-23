package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.EstadisticaPorMesDto;
import logistica_agrovision.log_agrov.Dto.RecepcionDto.EstadisticaPorProductoDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.EstadisticasRecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/estadisticas-recepcion")
public class EstadisticasRecepcionController {

    @Autowired
    private EstadisticasRecepcionService service;

    @GetMapping("/por-producto")
    public List<EstadisticaPorProductoDto> listarPorProducto() {
        return service.obtenerEstadisticaPorProducto();
    }

    @GetMapping("/por-mes")
    public List<EstadisticaPorMesDto> listarPorMes(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
        @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin
    ) {
        return service.obtenerEstadisticaPorMes(inicio, fin);
    }
}
