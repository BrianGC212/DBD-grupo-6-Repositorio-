package logistica_agrovision.log_agrov.Controller.TrazabilidadController;



import logistica_agrovision.log_agrov.Dto.TrazabilidadDto.DetalleProcesoDto;
import logistica_agrovision.log_agrov.Service.TrazabilidadService.DetalleProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trazabilidad")
public class DetalleProcesoController {

    @Autowired
    private DetalleProcesoService detalleProcesoService;

    @GetMapping("/detalleProceso/{codProceso}")
public List<DetalleProcesoDto> obtenerDetalleProceso(@PathVariable String codProceso) {
    return detalleProcesoService.obtenerDetallePorCodigo(codProceso);
}

  }