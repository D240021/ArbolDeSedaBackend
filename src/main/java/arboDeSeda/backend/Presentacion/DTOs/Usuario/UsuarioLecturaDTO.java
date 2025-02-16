package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import arboDeSeda.backend.Dominio.Usuario;

public record  UsuarioLecturaDTO(

         Integer id,
         String nombre,
         String apellidos,
         String telefono,
         String correo,
         String especialidad,
         String pais,
         String tipo

) {

    public UsuarioLecturaDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getCorreo(),
                usuario.getEspecialidad(),
                usuario.getPais(),
                usuario.getTipo()
        );
    }
}
