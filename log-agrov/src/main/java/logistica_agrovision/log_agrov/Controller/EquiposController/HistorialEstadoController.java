package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.HistorialEstadoService;
import logistica_agrovision.log_agrov.Dto.EquiposDto.HistorialEstadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${url.client}")
@RestController
@RequestMapping("/equipos")
public class HistorialEstadoController {

    @Autowired
    private HistorialEstadoService historialEstadoService;

    @GetMapping("/historial/{codEquipo}")
    public List<HistorialEstadoDto> obtenerHistorialEstado(@PathVariable String codEquipo) {
        return historialEstadoService.obtenerHistorialEstado(codEquipo);
    }
}
