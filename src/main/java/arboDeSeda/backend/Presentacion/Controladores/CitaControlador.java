package arboDeSeda.backend.Presentacion.Controladores;

import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Negocios.Servicios.CitaServicio;
import arboDeSeda.backend.Presentacion.DTOs.Cita.CitaDTOMapper;
import arboDeSeda.backend.Presentacion.DTOs.Cita.CitaLecturaDTO;
import arboDeSeda.backend.Presentacion.DTOs.Cita.CitaRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cita")
public class CitaControlador {

    @Autowired
    private final CitaServicio citaServicio;

    public CitaControlador(CitaServicio citaServicio) {
        this.citaServicio = citaServicio;
    }

    @PostMapping
    public ResponseEntity<Boolean> agendarCita(@RequestBody CitaRegistroDTO citaRegistroDTO){

        Cita cita = CitaDTOMapper.convertirCitaRegistroDTOACita(citaRegistroDTO);

        return ResponseEntity.created(null).body(this.citaServicio.agendarCita(cita));
    }

    @GetMapping("/{idPaciente")
    public ResponseEntity<List<CitaLecturaDTO>> obtenerCitasPorUsuario(@PathVariable int idPaciente){
        return ResponseEntity.ok(CitaDTOMapper.convertirCitasACitasLecturaDTO(this.citaServicio.obtenerCitasPorUsuario(idPaciente)));
    }
}
