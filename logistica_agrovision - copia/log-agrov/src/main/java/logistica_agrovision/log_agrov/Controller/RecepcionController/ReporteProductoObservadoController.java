package logistica_agrovision.log_agrov.Controller.RecepcionController;

import logistica_agrovision.log_agrov.Dto.RecepcionDto.FormularioReporteProductoDto;
import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistroReporteProductoDto;
import logistica_agrovision.log_agrov.Service.RecepcionService.ReporteProductoObservadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/reporte-producto-observado")
public class ReporteProductoObservadoController {

    @Autowired
    private ReporteProductoObservadoService service;

    // Mostrar datos para el formulario
    @GetMapping("/formulario/{idControlCalidad}")
    public FormularioReporteProductoDto mostrarFormulario(@PathVariable Integer idControlCalidad) {
        return service.obtenerDatosFormulario(idControlCalidad);
    }

    // Registrar reporte (solo lo que escribe el usuario)
    @PostMapping("/registrar")
    public void registrar(@RequestBody RegistroReporteProductoDto dto) {
        service.registrarReporte(dto);
    }
}
