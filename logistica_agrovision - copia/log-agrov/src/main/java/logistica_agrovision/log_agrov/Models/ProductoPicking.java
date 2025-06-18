package logistica_agrovision.log_agrov.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoPicking {
    private String id_producto;
    private String producto;
    private Integer cantidad;
    private String area;
    private String estado;
}
