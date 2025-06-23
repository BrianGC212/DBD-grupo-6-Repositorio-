package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarOrdenesTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/transporte")
public class VisualizarOrdenesTransporteController {

    @Autowired
    private VisualizarOrdenesTransporteService visualizarOrdenesTransporteService;

    @GetMapping("/ordenes")  // Este endpoint debe devolver las ordenes de transporte
    public ResponseEntity<List<Map<String, Object>>> obtenerOrdenesTransporte() {
        // Las ordenes de transporte
        List<Map<String, Object>> ordenes = visualizarOrdenesTransporteService.obtenerOrdenesTransporte();

        return ResponseEntity.ok(ordenes); // Retornamos los datos como una respuesta exitosa
    }
}
