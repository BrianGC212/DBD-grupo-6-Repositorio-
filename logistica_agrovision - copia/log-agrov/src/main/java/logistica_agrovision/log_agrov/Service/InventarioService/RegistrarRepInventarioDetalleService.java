package logistica_agrovision.log_agrov.Service.InventarioService;

import logistica_agrovision.log_agrov.Dto.InventarioDto.RegistrarRepInventarioDetalleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarRepInventarioDetalleService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarDetalle(RegistrarRepInventarioDetalleDto dto) {
        try {

            // Insertar el detalle de reporte de inventario
            String sqlInsert = "INSERT INTO Reporte_inventario_detalle ( id_reporte_inventario,\r\n" + //
                                "    id_lote,\r\n" + //
                                "    cantidad_esperada,\r\n" + //
                                "    cantidad_real,\r\n" + //
                                "    observacion) " +
                    "VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsert,
                    dto.getIdReporteInventario(),
                    dto.getIdLote(),
                    dto.getCantidadEsperada(),
                    dto.getCantidadReal(),
                    dto.getObservacion());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
