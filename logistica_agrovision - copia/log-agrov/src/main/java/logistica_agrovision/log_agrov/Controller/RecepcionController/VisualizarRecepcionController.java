package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Service.RecepcionService.VisualizarRecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/recepciones")
public class VisualizarRecepcionController {

    @Autowired
    private VisualizarRecepcionService visualizarRecepcionService;

    @GetMapping("/visualizar")
    public ResponseEntity<List<Map<String, Object>>> visualizarRecepciones() {
        List<Map<String, Object>> recepciones = visualizarRecepcionService.obtenerRecepciones();
        return ResponseEntity.ok(recepciones);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Map<String, Object>>> buscarPorProducto(@RequestParam String producto) {
        List<Map<String, Object>> resultados = visualizarRecepcionService.buscarRecepcionesPorProducto(producto);
        return ResponseEntity.ok(resultados);
    }
}
