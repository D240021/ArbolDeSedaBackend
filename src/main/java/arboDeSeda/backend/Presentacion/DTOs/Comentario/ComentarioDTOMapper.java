package arboDeSeda.backend.Presentacion.DTOs.Comentario;

import arboDeSeda.backend.Dominio.Comentario;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ComentarioDTOMapper {

    public static Comentario convertirComentarioRegistroDTOAComentario(ComentarioRegistroDTO comentarioRegistroDTO){
        return new Comentario(comentarioRegistroDTO);
    }

    public static Comentario convertirComentarioActualizacionDTOAComentario(ComentarioActualizacionDTO comentarioActualizacionDTO){
        return new Comentario(comentarioActualizacionDTO);
    }

    public static List<ComentarioLecturaDTO> convertirComentariosAComentariosLecturaDTO(List<Comentario> comentarios){
        return comentarios.stream()
                .map(ComentarioLecturaDTO::new)
                .collect(Collectors.toList());
    }
}

