package logistica_agrovision.log_agrov.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import logistica_agrovision.log_agrov.Dto.EquipoDTO;
import logistica_agrovision.log_agrov.Service.EquipoVisualizarService;
@RestController
@RequestMapping("/equipos")
public class EquipoVisualizarController {

    @Autowired
    private EquipoVisualizarService equipoVisualizarService;

    @GetMapping("/listar")
    public List<Map<String, Object>> listarEquipos() {
        return equipoVisualizarService.obtenerEquipos();
    }
}
