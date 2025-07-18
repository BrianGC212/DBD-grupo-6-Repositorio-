package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.EquipoDTO;
import logistica_agrovision.log_agrov.Service.EquiposService.EquipoVisualizarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${url.client}")
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
