package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import arboDeSeda.backend.Dominio.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTOMapper {

    public static List<UsuarioLecturaDTO> convertirUsuariosAUsuariosLecturaDTO(List<Usuario> usuarios){
        return usuarios.stream()
                .map(UsuarioLecturaDTO::new)
                .collect(Collectors.toList());
    }

    public static UsuarioLecturaDTO convertirUsuarioAUsuarioLecturaDTO(Usuario usuario){
        return new UsuarioLecturaDTO(usuario);
    }

    public static Usuario convertirUsuarioRegistroDTOAUsuario(UsuarioRegistroDTO usuarioRegistroDTO){
        return new Usuario(usuarioRegistroDTO);
    }
}
