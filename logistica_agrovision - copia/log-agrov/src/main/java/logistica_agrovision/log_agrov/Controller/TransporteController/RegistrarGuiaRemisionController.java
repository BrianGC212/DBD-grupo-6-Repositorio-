package logistica_agrovision.log_agrov.Controller.TransporteController;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarGuiaDto;
import logistica_agrovision.log_agrov.Service.TransporteService.RegistrarGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class RegistrarGuiaRemisionController
{
    @Autowired
    private RegistrarGuiaRemisionService registrarGuiaRemisionService;

    @PostMapping("/registrarGuia")  // El endpoint para registrar el equipo
    public String registrarGuiaR(@RequestBody RegistrarGuiaDto registrarGuiaDto) {
        boolean success = registrarGuiaRemisionService.registrarGuia(registrarGuiaDto);
        if (success) {
            return "La guia ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar la guia.";
        }
    }
}
