package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarGuiaRemisionService;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarInformeEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/transporte")
public class VisualizarInformeEntregaController {

    @Autowired
    private VisualizarInformeEntregaService visualizarInformeEntregaService;

    @GetMapping("/informeEntrega")  // Este endpoint debe devolver las guias de remision
    public ResponseEntity<List<Map<String, Object>>> obtenerInformeEntrega() {
        // Las ordenes de transporte
        List<Map<String, Object>> informesEntregas = visualizarInformeEntregaService.obtenerInformeEntrega();

        return ResponseEntity.ok(informesEntregas); // Retornamos los datos como una respuesta exitosa
    }
}
