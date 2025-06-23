package logistica_agrovision.log_agrov.Controller.EquiposController;

import logistica_agrovision.log_agrov.Dto.EquiposDto.LoginDto;
import logistica_agrovision.log_agrov.Service.EquiposService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

   
    @PostMapping("/autenticar")
    public ResponseEntity<String> autenticarEmpleado(@RequestBody LoginDto loginDto) {
       
        String result = loginService.autenticarEmpleado(loginDto);

      
        if (result.contains("correctos")) {
            return ResponseEntity.ok(result);  
        } else {
            return ResponseEntity.status(401).body(result); 
        }
    }
}
