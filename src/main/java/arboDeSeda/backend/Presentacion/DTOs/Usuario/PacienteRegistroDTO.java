package arboDeSeda.backend.Presentacion.DTOs.Usuario;

public record PacienteRegistroDTO(

         String cedula,
         String nombre,
         String apellidos,
         String telefono,
         String correo,
         String contrasenia
) {
}
