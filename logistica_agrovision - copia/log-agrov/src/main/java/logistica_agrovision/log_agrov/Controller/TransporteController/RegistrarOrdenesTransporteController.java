package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarOrdenTransporteDto;
import logistica_agrovision.log_agrov.Service.TransporteService.RegistrarOrdenTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class RegistrarOrdenesTransporteController {

    @Autowired
    private RegistrarOrdenTransporteService registrarOrdenTransporteService;

    @PostMapping("/registrarOrdenTransporte")  // El endpoint para registrar el equipo
    public String registrarOrden(@RequestBody RegistrarOrdenTransporteDto registrarOrdenTransporteDto) {
        boolean success = registrarOrdenTransporteService.registrarOrden(registrarOrdenTransporteDto);
        if (success) {
            return "La orden ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar la orden.";
        }
    }
}
