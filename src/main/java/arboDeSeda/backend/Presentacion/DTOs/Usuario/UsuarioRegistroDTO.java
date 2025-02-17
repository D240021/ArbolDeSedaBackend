package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record  UsuarioRegistroDTO(

         @NotBlank
         String nombreUsuario,
         @NotBlank
         String nombre,
         @NotBlank
         String apellidos,
         @NotBlank
         String telefono,
         @NotBlank
         String correo,
         @NotBlank
         String contrasenia,
         @Null
         String especialidad,
         @NotBlank
         String pais,
         @NotBlank
         String tipo
) {
}
