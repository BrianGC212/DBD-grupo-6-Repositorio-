package logistica_agrovision.log_agrov.Controller.TransporteController;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarInformeEntregaDto;
import logistica_agrovision.log_agrov.Service.TransporteService.RegistrarInformeEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class RegistrarInformeEntregaController {
    @Autowired
    private RegistrarInformeEntregaService registrarInformeEntregaService;

    @PostMapping("/registrarInforme")  // El endpoint para registrar el equipo
    public String registrarInformeE(@RequestBody RegistrarInformeEntregaDto registrarInformeEntregaDto) {
        boolean success = registrarInformeEntregaService.registrarInforme(registrarInformeEntregaDto);
        if (success) {
            return "El informe de entrega ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar el informe de entrega.";
        }
    }
}
