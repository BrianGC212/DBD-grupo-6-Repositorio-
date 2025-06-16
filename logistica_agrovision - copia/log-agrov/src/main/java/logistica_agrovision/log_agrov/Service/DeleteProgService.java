package logistica_agrovision.log_agrov.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Service
public class DeleteProgService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String deleteProgramacion(String codigo) {
        try {
            // Verifica que la programación exista y que no haya comenzado
            String sqlCheck = "SELECT COUNT(1) FROM PLANIFICACIONES_ASIGNACION WHERE COD_PLANIFICACIONES_ASIGNACION = ? AND Fecha_de_asignacion > NOW()";
            int count = jdbcTemplate.queryForObject(sqlCheck, Integer.class, codigo);

            if (count == 0) {
                return "Error: La programación ya ha comenzado o no existe.";
            }

            // Eliminar la programación
            String sqlDelete = "DELETE FROM PLANIFICACIONES_ASIGNACION WHERE COD_PLANIFICACIONES_ASIGNACION = ?";
            jdbcTemplate.update(sqlDelete, codigo);

            return "Programación eliminada exitosamente.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar la programación: " + e.getMessage();
        }
    }
}
