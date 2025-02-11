package arboDeSeda.backend.Presentacion.Controladores;

import arboDeSeda.backend.Dominio.Paciente;
import arboDeSeda.backend.Negocios.Servicios.PacienteServicio;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.PacienteDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.PacienteLecturaDTO;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.PacienteRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class PacienteControlador {

    @Autowired
    private final PacienteServicio usuarioServicio;

    public PacienteControlador(PacienteServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public ResponseEntity<List<PacienteLecturaDTO>> obtenerTodosUsuarios(){
        return ResponseEntity.ok(PacienteDTOMapper.convertirUsuariosAUsuariosLecturaDTO(this.usuarioServicio.obtenerTodosUsuarios()));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<PacienteLecturaDTO> obtenerUsuarioPorId(@PathVariable int idUsuario){
        return ResponseEntity.ok(PacienteDTOMapper.convertirUsuarioAUsuarioLecturaDTO(this.usuarioServicio.obtenerUsuarioPorId(idUsuario)));
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarUsuario(@RequestBody PacienteRegistroDTO pacienteRegistroDTO){

        Paciente nuevoPaciente = PacienteDTOMapper.convertirUsuarioRegistroDTOAUsuario(pacienteRegistroDTO);

        return ResponseEntity.created(null)
                .body(this.usuarioServicio.registrarUsuario(nuevoPaciente));
    }

}
