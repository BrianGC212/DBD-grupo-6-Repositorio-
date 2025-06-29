package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.VisualizarProgramacionesDto;
import logistica_agrovision.log_agrov.Service.EquiposService.VisualizarProgramacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/maquinas")
public class VisualizarProgramacionesController {

    @Autowired
    private VisualizarProgramacionesService visualizarProgramacionesService;

    @GetMapping("/programaciones")  
    public ResponseEntity<List<Map<String, Object>>> obtenerProgramaciones() {
      
        List<Map<String, Object>> programaciones = visualizarProgramacionesService.obtenerProgramaciones();
       
        return ResponseEntity.ok(programaciones); 
    }
}
