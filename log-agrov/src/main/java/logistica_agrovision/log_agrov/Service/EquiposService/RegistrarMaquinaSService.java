package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.RegistrarMaquinaSDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class RegistrarMaquinaSService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String registrarMaquinaSustituta(RegistrarMaquinaSDto dto) {
        try {
            String sqlEstado = "SELECT ID_EQUIPOS, ID_Tipo_Maquina FROM EQUIPOS WHERE COD_EQUIPOS = ? AND ID_Estado_equipo = 'MNT'";
            Map<String, Object> equipoOriginalData;
            try {
                equipoOriginalData = jdbcTemplate.queryForMap(sqlEstado, dto.getCodEquipo());
            } catch (EmptyResultDataAccessException e) {
                return "El equipo no está en mantenimiento o no existe en la base de datos.";
            }

            String tipoMaquinaId = (String) equipoOriginalData.get("ID_Tipo_Maquina");

            String sqlCount = "SELECT COUNT(1) FROM MAQUINAS_SUSTITUTAS";
            int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);

            String codigoSustituta = "M" + String.format("%07d", count + 1);
String sqlInsert = "INSERT INTO MAQUINAS_SUSTITUTAS (COD_MAQUINAS_SUSTITUTAS, Nombre_de_maquina, ID_Estado_equipo, ID_Tipo_Maquina, fecha_registro, ID_Empleado) " +
                   "VALUES (?, ?, ?, ?, NOW(), ?)";

            jdbcTemplate.update(sqlInsert, codigoSustituta, dto.getNombreMaquina(), dto.getEstadoMaquina(), tipoMaquinaId, dto.getIdEmpleado());

            String sqlIdSustituta = "SELECT ID_MAQUINAS_SUSTITUTAS FROM MAQUINAS_SUSTITUTAS WHERE COD_MAQUINAS_SUSTITUTAS = ?";
            Integer idMaquinaSustituta = jdbcTemplate.queryForObject(sqlIdSustituta, Integer.class, codigoSustituta);

            String sqlUpdateEquipo = "UPDATE EQUIPOS SET ID_MAQUINAS_SUSTITUTAS = ? WHERE COD_EQUIPOS = ?";
            jdbcTemplate.update(sqlUpdateEquipo, idMaquinaSustituta, dto.getCodEquipo());

            return "La máquina sustituta se ha registrado y actualizado correctamente.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al registrar la máquina sustituta. Detalles del error: " + e.getMessage();
        }
    }
}