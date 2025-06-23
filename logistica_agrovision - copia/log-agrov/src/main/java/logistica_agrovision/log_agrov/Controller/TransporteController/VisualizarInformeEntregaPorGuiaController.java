package logistica_agrovision.log_agrov.Controller.TransporteController;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarInformeEntregaPorGuiaDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarInformeEntregaPorGuiaDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarSeguimientoPorOrdenDto;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarInformeEntregaPorGuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transporte")
public class VisualizarInformeEntregaPorGuiaController {
    @Autowired
    private VisualizarInformeEntregaPorGuiaService visualizarInformeEntregaPorGuiaService;

    @PostMapping("/informePorGuia")
    public ResponseEntity<List<VisualizarInformeEntregaPorGuiaDto>> obtenerInformePorGuia(@RequestBody RegistrarInformeEntregaPorGuiaDto dto) {
        List<VisualizarInformeEntregaPorGuiaDto> detalles = visualizarInformeEntregaPorGuiaService.obtenerInformeEntregaPorGuia(dto);
        return ResponseEntity.ok(detalles);
    }
}
