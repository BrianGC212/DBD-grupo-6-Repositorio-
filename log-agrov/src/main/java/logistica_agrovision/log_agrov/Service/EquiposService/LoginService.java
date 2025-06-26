package logistica_agrovision.log_agrov.Service.EquiposService;

import logistica_agrovision.log_agrov.Dto.EquiposDto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public String autenticarEmpleado(LoginDto loginDto) {
        System.out.println("Usuario recibido: " + loginDto.getUsuario());
        System.out.println("Contraseña recibida: " + loginDto.getContrasena());

       
        String sql = "SELECT cargo FROM login WHERE usuario = ? AND contrasena = ?";
        String cargo = null;

        try {
            cargo = jdbcTemplate.queryForObject(sql, String.class, loginDto.getUsuario(), loginDto.getContrasena());
        } catch (EmptyResultDataAccessException e) {
            
            System.out.println("Error: Usuario o contraseña incorrectos.");
            return "Usuario o contraseña incorrectos";
        }

       
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
