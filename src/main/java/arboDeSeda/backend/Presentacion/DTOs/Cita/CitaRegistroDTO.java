package arboDeSeda.backend.Presentacion.DTOs.Cita;

import arboDeSeda.backend.Dominio.Paciente;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public record CitaRegistroDTO (

        LocalDate fechaHora,

        int idPaciente,

        int idMedico
){
}
