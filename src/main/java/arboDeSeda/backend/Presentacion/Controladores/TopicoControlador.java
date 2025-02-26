package arboDeSeda.backend.Presentacion.Controladores;

import arboDeSeda.backend.Dominio.Topico;
import arboDeSeda.backend.Negocios.Servicios.TopicoServicio;
import arboDeSeda.backend.Presentacion.DTOs.Topico.TopicoDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Topico.TopicoLecturaDTO;
import arboDeSeda.backend.Presentacion.DTOs.Topico.TopicoRegistroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoControlador {

    @Autowired
    private final TopicoServicio topicoServicio;

    public TopicoControlador(TopicoServicio topicoServicio) {
        this.topicoServicio = topicoServicio;
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarTopico(@RequestBody @Valid TopicoRegistroDTO topicoRegistroDTO){

        Topico topico = TopicoDTOMapper.convertirTopicoRegistroDTOATopico(topicoRegistroDTO);

        return ResponseEntity.created(null).body(this.topicoServicio.registrarTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<TopicoLecturaDTO>> obtenerTodosTopicos() {
        return ResponseEntity.ok(TopicoDTOMapper.convertirTopicosATopicosLecturaDTO(this.topicoServicio.obtenerTodosTopicos()));
    }

}
