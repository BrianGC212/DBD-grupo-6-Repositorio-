package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.RegistrarMovInventarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarMovInventarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarMovimiento(RegistrarMovInventarioDto dto) {
        try {
            // Obtener el número de movimientos registrados para generar un nuevo código
            String sqlCount = "SELECT COUNT(1) FROM movimiento_inventario";
            int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);

            // Generar código del movimiento: MOV + número con ceros
            String codMovimiento = "MOV" + String.format("%05d", count + 1);

            // Obtener el id del producto por el id del lote
            int id_lote = dto.getIdLote();
            String sqlGetLote = "SELECT id_producto FROM Lote WHERE id_lote = ?";
            String idProducto = jdbcTemplate.queryForObject(sqlGetLote, String.class, id_lote);

            // Insertar el movimiento de inventario
            String sqlInsert = "INSERT INTO movimiento_inventario (cod_movimiento_inventario, id_tipo_movimiento, motivo, cantidad, fecha_movimiento, id_lote, id_producto, id_empleado, origen, destino) " +
                    "VALUES (?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sqlInsert,
                    codMovimiento,
                    dto.getTipoMovimiento(),
                    dto.getMotivo(),
                    dto.getCantidad(),
                    id_lote,
                    idProducto,
                    dto.getIdEmpleado(),
                    dto.getOrigen(),
                    dto.getDestino());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
