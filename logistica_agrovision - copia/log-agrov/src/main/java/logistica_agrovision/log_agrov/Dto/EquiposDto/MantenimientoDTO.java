package logistica_agrovision.log_agrov.Dto.EquiposDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MantenimientoDTO {
    private String codigoMantenimiento;
    private Date fechaInicio;
    private String empresaEncargada;  
    private int codigoEquipo; 
    private String idEstadoEquipo;  
    private String idEstadoMantenimiento;  
    private int idEmpleadoRegistra;  
    private int idEmpleadoSolicita; 
    private Integer codigoMaquinaSustituta;
 
}
