package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarGuiaDetalleDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.VisualizarGuiaDetalleDto;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarGuiaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class VisualizarGuiaDetalleController {

    @Autowired
    private VisualizarGuiaDetalleService guiaDetalleService;

    @PostMapping("/detalleGuia")
    public ResponseEntity<List<VisualizarGuiaDetalleDto>> obtenerDetalleGuia(@RequestBody RegistrarGuiaDetalleDto dto) {
        List<VisualizarGuiaDetalleDto> detalles = guiaDetalleService.obtenerDetalleGuia(dto);
        return ResponseEntity.ok(detalles);
    }
}
