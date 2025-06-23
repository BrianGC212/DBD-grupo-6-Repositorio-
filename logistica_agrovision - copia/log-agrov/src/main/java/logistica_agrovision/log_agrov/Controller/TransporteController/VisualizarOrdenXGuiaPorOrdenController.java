package logistica_agrovision.log_agrov.Controller.TransporteController;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarOrdenXGuiaPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarOrdenXGuiaPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarOrdenXGuiaPorOrdenService;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarSeguimientoPorOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transporte")
public class VisualizarOrdenXGuiaPorOrdenController {
    @Autowired
    private VisualizarOrdenXGuiaPorOrdenService visualizarOrdenXGuiaPorOrdenService;

    @PostMapping("/ordenxguiaPorOrden")
    public ResponseEntity<List<VisualizarOrdenXGuiaPorOrdenDto>> obtenerSeguimientoPorOrden(@RequestBody RegistrarOrdenXGuiaPorOrdenDto dto) {
        List<VisualizarOrdenXGuiaPorOrdenDto> detalles = visualizarOrdenXGuiaPorOrdenService.obtenerOrdenXGuiaPorOrden(dto);
        return ResponseEntity.ok(detalles);
    }
}
