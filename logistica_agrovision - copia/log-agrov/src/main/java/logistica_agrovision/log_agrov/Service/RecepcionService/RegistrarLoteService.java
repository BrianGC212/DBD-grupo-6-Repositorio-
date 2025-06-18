package logistica_agrovision.log_agrov.Service.RecepcionService;


import logistica_agrovision.log_agrov.Dto.RecepcionDto.RegistrarLoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarLoteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarLote(RegistrarLoteDto dto) {
        try {
            // Obtener el número de lotes registrados para generar un nuevo código
            String sqlCount = "SELECT COUNT(1) FROM Lote";
            int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);

            // Generar código del lote: LOT + número con ceros
            String codLote = "LOT" + String.format("%05d", count + 1);

            // El estado es fijo como 'PT'
            String estadoLote = "PT";
            java.sql.Date fechaProduccion = java.sql.Date.valueOf(dto.getFechaProduccion());
            java.sql.Date fechaVencimiento = java.sql.Date.valueOf(dto.getFechaVencimiento());

            // Insertar el lote
            String sqlInsert = "INSERT INTO Lote (cod_lote, id_tipo_lote, cantidad_total, unidad, fecha_vencimiento, id_estado_lote, fecha_produccion, id_producto) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sqlInsert,
                    codLote,
                    dto.getIdTipoLote(),
                    dto.getCantidadTotal(),
                    dto.getUnidad(),
                    fechaVencimiento,
                    estadoLote,
                    fechaProduccion,
                    dto.getIdProducto());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
