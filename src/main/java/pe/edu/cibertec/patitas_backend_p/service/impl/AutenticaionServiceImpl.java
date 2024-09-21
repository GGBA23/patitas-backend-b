package pe.edu.cibertec.patitas_backend_p.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.patitas_backend_p.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_backend_p.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Service
public class AutenticaionServiceImpl implements AutenticacionService{

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException {
        String[] datosUsuario = null;
        //Hace referencia al archivo ubicado dentro del proy en la carperta resources
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        //trae el archivo que hemos guardado en la variable resource
        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            String liena;
            while ((liena = br.readLine()) != null){

                String[] datos = liena.split(";");
                if (loginRequestDTO.tipoDocumento().equals(datos[0]) &&
                    loginRequestDTO.numeroDocumento().equals(datos[1]) &&
                    loginRequestDTO.password().equals(datos[2])) {

                    datosUsuario = new String[2];
                    datosUsuario[0] = datos[3]; // Recuperar nombre
                    datosUsuario[1] = datos[4]; // Recuperar email

                }

            }

        }catch (IOException e){
            datosUsuario = null;
            throw new IOException(e);
        }

        return datosUsuario;
    }
}
