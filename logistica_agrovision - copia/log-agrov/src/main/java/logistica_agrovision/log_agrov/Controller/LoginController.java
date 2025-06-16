package logistica_agrovision.log_agrov.Controller;

import logistica_agrovision.log_agrov.Dto.LoginDto;
import logistica_agrovision.log_agrov.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Endpoint para autenticar al empleado
    @PostMapping("/autenticar")
    public ResponseEntity<String> autenticarEmpleado(@RequestBody LoginDto loginDto) {
        // Llamada al servicio de autenticación
        String result = loginService.autenticarEmpleado(loginDto);

        // Responder con el mensaje adecuado
        if (result.contains("correctos")) {
            return ResponseEntity.ok(result);  // Autenticación exitosa
        } else {
            return ResponseEntity.status(401).body(result);  // Error en la autenticación
        }
    }
}
