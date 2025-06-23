package logistica_agrovision.log_agrov.Service.TransporteService;

import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarGuiaDto;
import logistica_agrovision.log_agrov.Dto.TransporteDto.RegistrarInformeEntregaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrarInformeEntregaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registrarInforme(RegistrarInformeEntregaDto dto) {
        try {

            String sqlInsert ="INSERT INTO informe_entrega(nombre_receptor,dni_receptor,observacion,id_guia_remision) " +
                    "VALUES(?, ?, ?,(SELECT id_guia_remision FROM guia_de_remision WHERE cod_guia_remision = ?))";
            jdbcTemplate.update(sqlInsert, dto.getNombre_receptor(),dto.getDni_receptor(), dto.getObservacion(),
                    dto.getCod_guia_remision());

            return true;
        } catch (Exception e) {
            // Si ocurre un error, imprimirlo y retornar false
            e.printStackTrace();
            return false;
        }
    }
}
