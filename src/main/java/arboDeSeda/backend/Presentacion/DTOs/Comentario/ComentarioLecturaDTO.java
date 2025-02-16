package arboDeSeda.backend.Presentacion.DTOs.Comentario;

import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioLecturaDTO;

import java.time.LocalDate;

public record ComentarioLecturaDTO (

        int id,
        UsuarioLecturaDTO usuarioLecturaDTO,
        LocalDate fechaHora,
        String contenido
) {
    public ComentarioLecturaDTO(Comentario comentario) {
        this(comentario.getId(),
                UsuarioDTOMapper.convertirUsuarioAUsuarioLecturaDTO(comentario.getUsuario()),
                comentario.getFecha(),comentario.getContenido());
    }
}
