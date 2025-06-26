package logistica_agrovision.log_agrov.Dto.PedidosDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarEmpaqueDto {
    String nombre;
    String id_tipo_empaque;
    String descripcion;
    int capacidad_maxima;
    int id_lote;
}
