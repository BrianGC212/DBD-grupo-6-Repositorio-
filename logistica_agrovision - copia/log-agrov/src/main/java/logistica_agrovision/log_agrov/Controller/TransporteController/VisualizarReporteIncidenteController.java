package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarGuiaRemisionService;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarReporteIncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/transporte")
public class VisualizarReporteIncidenteController {

    @Autowired
    private VisualizarReporteIncidenteService visualizarReporteIncidenteService;

    @GetMapping("/reporteIncidente")  // Este endpoint debe devolver las guias de remision
    public ResponseEntity<List<Map<String, Object>>> obtenerReporteIncidente() {
        // Las ordenes de transporte
        List<Map<String, Object>> reportesIncidente = visualizarReporteIncidenteService.obtenerReporteIncidente();

        return ResponseEntity.ok(reportesIncidente); // Retornamos los datos como una respuesta exitosa
    }
}
