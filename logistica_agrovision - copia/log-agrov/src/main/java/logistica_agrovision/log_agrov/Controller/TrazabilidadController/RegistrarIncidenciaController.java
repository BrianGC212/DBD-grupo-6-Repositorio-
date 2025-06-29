package logistica_agrovision.log_agrov.Controller.TrazabilidadController;

import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.RegistrarIncidenciaDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.RegistrarIncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class RegistrarIncidenciaController {

    @Autowired
    private RegistrarIncidenciaService registrarIncidenciaService;

    @PostMapping("/registrarIncidencia")
    public boolean registrarIncidencia(@RequestBody RegistrarIncidenciaDto registrarIncidenciaDto) {
        return registrarIncidenciaService.registrarIncidencia(registrarIncidenciaDto);
    }
}
