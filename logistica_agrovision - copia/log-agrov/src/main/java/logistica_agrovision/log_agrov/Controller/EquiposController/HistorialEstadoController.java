package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Service.EquiposService.HistorialEstadoService;
import logistica_agrovision.log_agrov.Dto.EquiposDto.HistorialEstadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
