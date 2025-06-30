package logistica_agrovision.log_agrov.Controller.TransporteController;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarReporteIncidentesDto;
import logistica_agrovision.log_agrov.Service.TransporteService.RegistrarReporteIncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transporte")
public class RegistrarReporteIncidentesController {
    @Autowired
    private RegistrarReporteIncidenteService registrarReporteIncidenteService;

    @PostMapping("/registrarReporteIncid")  // El endpoint para registrar el equipo
    public String registrarReporteInc(@RequestBody RegistrarReporteIncidentesDto registrarReporteIncidentesDto) {
        boolean success = registrarReporteIncidenteService.registrarReporteIncidentes(registrarReporteIncidentesDto);
        if (success) {
            return "El reporte ha sido registrado.";
        } else {
            return "Hubo un error al registrar.";
        }
    }

}
