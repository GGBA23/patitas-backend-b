package pe.edu.cibertec.patitas_backend_p.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.patitas_backend_p.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_backend_p.dto.LoginResponseDTO;

@RestController
@RequestMapping("/autenticacion")
public class AutenticationController {

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return new LoginResponseDTO("00","","Gonzalo Bautista","gonza@gmail.com");
    }
}
