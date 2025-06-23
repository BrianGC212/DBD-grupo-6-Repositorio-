package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoDto;
import logistica_agrovision.log_agrov.Service.TransporteService.RegistrarSeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class RegistrarSeguimientoController {
    @Autowired
    private RegistrarSeguimientoService registrarSeguimientoService;

    @PostMapping("/registrarSeg")  // El endpoint para registrar el equipo
    public String registrarSeguimiento(@RequestBody RegistrarSeguimientoDto registrarSeguimientoDto) {
        boolean success = registrarSeguimientoService.registrarSeguimiento(registrarSeguimientoDto);
        if (success) {
            return "La Seguimiento ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar la Seguimiento.";
        }
    }
}
