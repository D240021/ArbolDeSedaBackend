package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import arboDeSeda.backend.Dominio.Usuario;

public record UsuarioLecturaDTO(

         Integer id,
         String cedula,
         String nombre,
         String apellidos,
         String telefono,
         String correo

) {

    public UsuarioLecturaDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getCorreo()
        );
    }
}
