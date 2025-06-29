package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/maquinas")
public class CalendarioController {

    @Autowired
    private CalendarioService calendarioService;

    /**
     * Endpoint para obtener los equipos y áreas programados para una fecha específica.
     *
     * @param fecha La fecha que se pasa en la URL (en formato YYYY-MM-DD).
     * @return Una lista de equipos y áreas programados.
     */
    @GetMapping("/programarAsignacion")
    public List<Map<String, Object>> programarAsignacion(@RequestParam("fecha") String fecha) {
        return calendarioService.obtenerEquiposYAreasPorFecha(fecha);
    }
}
