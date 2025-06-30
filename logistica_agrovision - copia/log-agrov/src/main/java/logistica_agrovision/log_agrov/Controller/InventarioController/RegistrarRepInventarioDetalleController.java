package logistica_agrovision.log_agrov.Controller.InventarioController;

import logistica_agrovision.log_agrov.Dto.InventarioDto.RegistrarRepInventarioDetalleDto;
import logistica_agrovision.log_agrov.Service.InventarioService.RegistrarRepInventarioDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/reporte-inventario-detalle")
public class RegistrarRepInventarioDetalleController {
    
    @Autowired
    private RegistrarRepInventarioDetalleService registrarRepInventarioDetalleService;

    @PostMapping("/registrar")
    public String registrarReporteInventarioDetalle(@RequestBody RegistrarRepInventarioDetalleDto dto) {
        boolean success = registrarRepInventarioDetalleService.registrarDetalle(dto);
        if (success) {
            return "El reporte de inventario detalle ha sido registrado con éxito.";
        } else {
            return "Hubo un error al registrar el reporte de inventario detalle.";
        }
    }

}
