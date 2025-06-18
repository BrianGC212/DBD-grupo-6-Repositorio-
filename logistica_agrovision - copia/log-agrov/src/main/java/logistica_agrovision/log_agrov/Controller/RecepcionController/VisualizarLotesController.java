package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Service.RecepcionService.VisualizarLotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lotes")
public class VisualizarLotesController {

    @Autowired
    private VisualizarLotesService visualizarLotesService;

    @GetMapping("/visualizar") // Endpoint para obtener lotes
    public ResponseEntity<List<Map<String, Object>>> obtenerLotes() {
        List<Map<String, Object>> lotes = visualizarLotesService.obtenerLotes();
        return ResponseEntity.ok(lotes);
    }
}
