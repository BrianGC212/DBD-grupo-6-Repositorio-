package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.ActualizarStockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActualizarStockService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public boolean actualizarStock(ActualizarStockDto dto) {
        String sql = "UPDATE Lote SET cantidad_total = ? WHERE id_lote = ?";
        
        int rowsAffected = jdbcTemplate.update(sql, dto.getCantidadReal(), dto.getIdLote());
        
        return rowsAffected > 0; // Retorna true si se actualizó al menos una fila
    }

}
