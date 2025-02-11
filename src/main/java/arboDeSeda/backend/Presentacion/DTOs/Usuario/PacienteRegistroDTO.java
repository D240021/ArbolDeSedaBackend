package arboDeSeda.backend.Presentacion.DTOs.Usuario;

public record UsuarioRegistroDTO(

         String cedula,
         String nombre,
         String apellidos,
         String telefono,
         String correo,
         String contrasenia
) {
}
