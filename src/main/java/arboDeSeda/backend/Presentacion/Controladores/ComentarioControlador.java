package arboDeSeda.backend.Presentacion.Controladores;

import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Negocios.Servicios.ComentarioServicio;
import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioActualizacionDTO;
import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioLecturaDTO;
import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioControlador {

    @Autowired
    private final ComentarioServicio comentarioServicio;

    public ComentarioControlador(ComentarioServicio comentarioServicio) {
        this.comentarioServicio = comentarioServicio;
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarComentario(@RequestBody ComentarioRegistroDTO comentarioRegistroDTO){

        Comentario comentario = ComentarioDTOMapper.convertirComentarioRegistroDTOAComentario(comentarioRegistroDTO);

        return ResponseEntity.created(null).body( this.comentarioServicio.registrarComentario(comentario));
    }

    @PutMapping
    public ResponseEntity<Boolean> actualizarComentario(@RequestBody ComentarioActualizacionDTO comentarioActualizacionDTO){

        Comentario comentario = ComentarioDTOMapper.convertirComentarioActualizacionDTOAComentario(comentarioActualizacionDTO);

        return ResponseEntity.ok(this.comentarioServicio.actualizarComentario(comentario));
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<List<ComentarioLecturaDTO>> obtenerComentariosPorTopico(@PathVariable int idTopico){
        return ResponseEntity.ok(ComentarioDTOMapper.convertirComentariosAComentariosLecturaDTO(this.comentarioServicio.obtenerComentariosPorTopico(idTopico)));
    }

}
