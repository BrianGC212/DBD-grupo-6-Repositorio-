package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Dto.VisualizarProgramacionesDto;
import logistica_agrovision.log_agrov.Service.VisualizarProgramacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/maquinas")
public class VisualizarProgramacionesController {

    @Autowired
    private VisualizarProgramacionesService visualizarProgramacionesService;

    @GetMapping("/programaciones")  // Este endpoint debe devolver las programaciones
    public ResponseEntity<List<Map<String, Object>>> obtenerProgramaciones() {
        // Aquí obtienes las programaciones desde el servicio
        List<Map<String, Object>> programaciones = visualizarProgramacionesService.obtenerProgramaciones();
       
        return ResponseEntity.ok(programaciones); // Retornamos los datos como una respuesta exitosa
    }
}
