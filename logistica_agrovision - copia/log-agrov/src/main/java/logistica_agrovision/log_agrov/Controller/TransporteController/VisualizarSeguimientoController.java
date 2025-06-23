package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Service.TransporteService.VisualizarSeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/transporte")
public class VisualizarSeguimientoController {

    @Autowired
    private VisualizarSeguimientoService visualizarSeguimientoService;

    @GetMapping("/seguimiento")  // Este endpoint debe devolver las seguimientos
    public ResponseEntity<List<Map<String, Object>>> obtenerSeguimiento() {
        // Aquí obtienes las seguimientos desde el servicio
        List<Map<String, Object>> seguimientos = visualizarSeguimientoService.obtenerSeguimiento();

        return ResponseEntity.ok(seguimientos); // Retornamos los datos como una respuesta exitosa
    }
}
