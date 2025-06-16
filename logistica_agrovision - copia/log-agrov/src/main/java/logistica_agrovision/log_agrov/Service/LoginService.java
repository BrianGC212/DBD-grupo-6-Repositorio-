package logistica_agrovision.log_agrov.Service;

import logistica_agrovision.log_agrov.Dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para autenticar al empleado
    public String autenticarEmpleado(LoginDto loginDto) {
        // Imprimir los valores recibidos para asegurarse de que el usuario y la contraseña están bien recibidos
        System.out.println("Usuario recibido: " + loginDto.getUsuario());
        System.out.println("Contraseña recibida: " + loginDto.getContrasena());

        // SQL query para verificar usuario y contraseña
        String sql = "SELECT cargo FROM login WHERE usuario = ? AND contrasena = ?";
        String cargo = null;

        try {
            // Ejecutar la consulta para obtener el cargo del usuario
            cargo = jdbcTemplate.queryForObject(sql, String.class, loginDto.getUsuario(), loginDto.getContrasena());
        } catch (EmptyResultDataAccessException e) {
            // Si no se encuentra el usuario o contraseña incorrectos
            System.out.println("Error: Usuario o contraseña incorrectos.");
            return "Usuario o contraseña incorrectos";
        }

        // Si el cargo es válido
        if (cargo != null) {
            if (cargo.equals("operador_Equipos")) {
                return "Autenticación exitosa. Acceso concedido a registro de equipos.";
            } else {
                return "Acceso denegado. El empleado no tiene el cargo de 'operador_Equipos'.";
            }
        } else {
            return "Usuario o contraseña incorrectos.";
        }
    }
}
