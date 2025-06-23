package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/transporte")
public class VisualizarGuiaRemisionController {

    @Autowired
    private VisualizarGuiaRemisionService visualizarGuiaRemisionService;

    @GetMapping("/guiaRemision")  // Este endpoint debe devolver las guias de remision
    public ResponseEntity<List<Map<String, Object>>> obtenerGuiaRemision() {
        // Las ordenes de transporte
        List<Map<String, Object>> guiaRemisiones = visualizarGuiaRemisionService.obtenerGuiaRemision();

        return ResponseEntity.ok(guiaRemisiones); // Retornamos los datos como una respuesta exitosa
    }
}
