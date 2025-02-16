package arboDeSeda.backend.Presentacion.DTOs.Topico;

import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Dominio.Topico;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioLecturaDTO;

import java.util.List;

public record TopicoLecturaDTO (

        int id,
        String asunto,
        String contenido,
        UsuarioLecturaDTO usuarioLecturaDTO,
        List<Comentario> comentarios

) {

    public TopicoLecturaDTO (Topico topico){
        this(topico.getId(), topico.getAsunto(), topico.getAsunto(), UsuarioDTOMapper.convertirUsuarioAUsuarioLecturaDTO(topico.getUsuario()), topico.getComentarios());
    }

}
