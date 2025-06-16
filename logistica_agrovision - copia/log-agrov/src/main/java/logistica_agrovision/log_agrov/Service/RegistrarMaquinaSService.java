package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.RegistrarMaquinaSDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegistrarMaquinaSService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Registers a substitute machine if the original equipment is currently in 'MNT' (maintenance) status.
     * This method handles the validation, code generation, database insertion, and updates.
     *
     * @param dto The data transfer object containing the necessary information from the request,
     * including the original equipment code, new substitute machine details, and employee ID.
     * @return A {@code String} message indicating the outcome of the registration process (success or specific error).
     */
    public String registrarMaquinaSustituta(RegistrarMaquinaSDto dto) {
        try {
            // 1. Verify that the original equipment exists AND is in 'MNT' (Maintenance) status.
            // We use queryForMap to fetch the equipment and its type ID in a single, robust query.
            String sqlEstado = "SELECT ID_EQUIPOS, ID_Tipo_Maquina FROM EQUIPOS WHERE COD_EQUIPOS = ? AND ID_Estado_equipo = 'MNT'";
            Map<String, Object> equipoOriginalData;
            try {
                equipoOriginalData = jdbcTemplate.queryForMap(sqlEstado, dto.getCodEquipo());
            } catch (EmptyResultDataAccessException e) {
                // If no record matches the criteria (either code doesn't exist or not in 'MNT'),
                // we return an informative message and stop the process.
                return "El equipo no está en mantenimiento o no existe en la base de datos.";
            }

            // Extract the required information from the query result.
            // int idEquipo = (int) equipoOriginalData.get("ID_EQUIPOS"); // Not strictly needed for this logic path
            String tipoMaquinaId = (String) equipoOriginalData.get("ID_Tipo_Maquina"); // Still used for context, but not for prefix

            // 2. Generate a unique code for the new substitute machine.
            // THIS IS THE MODIFIED PART to ensure 'M' followed by 7 digits.
            // For production environments, consider using database sequences or UUIDs for collision-free IDs.
            String sqlCount = "SELECT COUNT(1) FROM MAQUINAS_SUSTITUTAS";
            int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);

            // Construct the substitute machine's code as 'M' followed by 7 digits.
            // We ensure the number is padded with leading zeros to make it 7 digits long.
            String codigoSustituta = "M" + String.format("%07d", count + 1); // e.g., "M0000001", "M0000015"

            // 3. Insert the new substitute machine record into the `MAQUINAS_SUSTITUTAS` table.
            String sqlInsert = "INSERT INTO MAQUINAS_SUSTITUTAS (COD_MAQUINAS_SUSTITUTAS, Nombre_de_maquina, ID_Estado_equipo, ID_Tipo_Maquina, fecha_registro, ID_Empleado) " +
                               "VALUES (?, ?, ?, ?, NOW(), ?)";

            // Perform the insert operation.
            jdbcTemplate.update(sqlInsert, codigoSustituta, dto.getNombreMaquina(), dto.getEstadoMaquina(), tipoMaquinaId, dto.getIdEmpleado());

            // 4. Retrieve the ID_MAQUINAS_SUSTITUTAS of the newly inserted substitute machine.
            // This requires an additional query to the database, assuming COD_MAQUINAS_SUSTITUTAS is unique.
            String sqlIdSustituta = "SELECT ID_MAQUINAS_SUSTITUTAS FROM MAQUINAS_SUSTITUTAS WHERE COD_MAQUINAS_SUSTITUTAS = ?";
            Integer idMaquinaSustituta = jdbcTemplate.queryForObject(sqlIdSustituta, Integer.class, codigoSustituta);

            // 5. Update the original `EQUIPOS` record to link it with the newly registered substitute machine.
            String sqlUpdateEquipo = "UPDATE EQUIPOS SET ID_MAQUINAS_SUSTITUTAS = ? WHERE COD_EQUIPOS = ?";
            jdbcTemplate.update(sqlUpdateEquipo, idMaquinaSustituta, dto.getCodEquipo());

            // If all steps complete successfully, return a success message.
            return "La máquina sustituta se ha registrado y actualizado correctamente.";

        } catch (Exception e) {
            // Catch any unexpected errors (e.g., database connection issues, constraint violations)
            // Log the full stack trace for detailed debugging.
            e.printStackTrace();
            // Return a generic error message with details for the user.
            return "Error al registrar la máquina sustituta. Detalles del error: " + e.getMessage();
        }
    }
}