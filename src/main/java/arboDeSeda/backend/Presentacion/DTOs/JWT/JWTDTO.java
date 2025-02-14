package arboDeSeda.backend.Presentacion.DTOs.JWT;

import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioLecturaDTO;

public record JWTDTO(

        String token,
        UsuarioLecturaDTO usuarioLecturaDTO
) {
}
