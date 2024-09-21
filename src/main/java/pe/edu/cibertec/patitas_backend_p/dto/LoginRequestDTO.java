package pe.edu.cibertec.patitas_backend_p.dto;

public record LoginRequestDTO(String tipoDocumento, String numeroDocumento, String password) {
}
