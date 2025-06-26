package logistica_agrovision.log_agrov.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Picking {
    String pedido;
    String nombre_empleado;
    String fecha_limite;
    String destino;
    String estado;
}
