package pe.edu.cibertec.patitas_backend_p.service;

import pe.edu.cibertec.patitas_backend_p.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;


}
