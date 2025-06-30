package logistica_agrovision.log_agrov.Service.TransporteService;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarReporteIncidentesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarReporteIncidenteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarReporteIncidentes(RegistrarReporteIncidentesDto dto) {
        try {
            Integer id_cliente = Integer.parseInt(dto.getId_cliente());
            String sqlInsert ="INSERT INTO reporte_incidentes_entrega (id_estado_reporte, descripcion, id_tipo_incidente, id_cliente, nombre_realiza, dni_realiza, id_informe_entrega,id_empleado) " +
                    "VALUES (?, ?, ?, ?,?,?,(SELECT ie.id_informe_entrega FROM informe_entrega ie INNER JOIN guia_de_remision g ON g.id_guia_remision = ie.id_informe_entrega WHERE g.cod_guia_remision = ?),(SELECT id_empleado FROM Empleado WHERE cod_empleado = ?));";
            jdbcTemplate.update(sqlInsert, dto.getId_estado_reporte(), dto.getDescripcion(), dto.getId_tipo_incidente(),
                    id_cliente, dto.getNombre_realiza(), dto.getDni_realiza(), dto.getCod_guia_remision(), dto.getCod_empleado());

            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }
}
