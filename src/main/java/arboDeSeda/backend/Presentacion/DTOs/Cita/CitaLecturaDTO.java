package arboDeSeda.backend.Presentacion.DTOs.Cita;

import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Dominio.Paciente;

import java.time.LocalDate;

public record CitaLecturaDTO (

        LocalDate fechaHora,
        Paciente paciente,
        int idMedico
){

    public CitaLecturaDTO(Cita cita){
        this(cita.getFechaHora(),cita.getPaciente(), cita.getId());
    }
}
