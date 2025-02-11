package arboDeSeda.backend.Presentacion.Controladores;

import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Negocios.Servicios.UsuarioServicio;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioLecturaDTO;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioLecturaDTO>> obtenerTodosUsuarios(){
        return ResponseEntity.ok(UsuarioDTOMapper.convertirUsuariosAUsuariosLecturaDTO(this.usuarioServicio.obtenerTodosUsuarios()));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioLecturaDTO> obtenerUsuarioPorId(@PathVariable int idUsuario){
        return ResponseEntity.ok(UsuarioDTOMapper.convertirUsuarioAUsuarioLecturaDTO(this.usuarioServicio.obtenerUsuarioPorId(idUsuario)));
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarUsuario(@RequestBody UsuarioRegistroDTO usuarioRegistroDTO){

        Usuario nuevoUsuario = UsuarioDTOMapper.convertirUsuarioRegistroDTOAUsuario(usuarioRegistroDTO);

        return ResponseEntity.created(null)
                .body(this.usuarioServicio.registrarUsuario(nuevoUsuario));
    }

}
