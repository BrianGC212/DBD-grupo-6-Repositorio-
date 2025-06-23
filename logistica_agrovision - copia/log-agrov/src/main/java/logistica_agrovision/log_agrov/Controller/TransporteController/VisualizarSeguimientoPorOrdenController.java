package logistica_agrovision.log_agrov.Controller.TransporteController;

import java.util.List;
import java.util.Map;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarSeguimientoPorOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/transporte")
public class VisualizarSeguimientoPorOrdenController {
    @Autowired
    private VisualizarSeguimientoPorOrdenService visualizarSeguimientoPorOrdenService;

    @PostMapping("/seguimientoPorOrden")
    public ResponseEntity<List<VisualizarSeguimientoPorOrdenDto>> obtenerSeguimientoPorOrden(@RequestBody RegistrarSeguimientoPorOrdenDto dto) {
        List<VisualizarSeguimientoPorOrdenDto> detalles = visualizarSeguimientoPorOrdenService.obtenerSeguimientoPorOrden(dto);
        return ResponseEntity.ok(detalles);
    }

}
