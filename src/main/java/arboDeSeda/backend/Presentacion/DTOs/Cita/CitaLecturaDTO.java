package arboDeSeda.backend.Presentacion.DTOs.Cita;

import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Dominio.Usuario;

import java.time.LocalDate;
import java.util.Date;

public record CitaLecturaDTO (

        Date fechaHora,
        Usuario usuario,
        int idMedico
){

    public CitaLecturaDTO(Cita cita){
        this(cita.getFechaHora(),cita.getUsuario(), cita.getId());
    }
}
