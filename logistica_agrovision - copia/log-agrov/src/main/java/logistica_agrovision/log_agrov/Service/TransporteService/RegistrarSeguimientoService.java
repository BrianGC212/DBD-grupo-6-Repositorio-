package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarSeguimientoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class RegistrarSeguimientoService
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarSeguimiento(RegistrarSeguimientoDto dto) {
        try {


            String sqlInsert = "INSERT INTO seguimiento (descripcion, id_estado_seguimiento, id_orden_transporte) " +
                    "SELECT ?, ?, id_orden_transporte FROM orden_transporte WHERE cod_orden_transporte = ? ";
            jdbcTemplate.update(sqlInsert, dto.getDescripcion(), dto.getId_estado_seguimiento(), dto.getCod_orden_transporte());

            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }
}
