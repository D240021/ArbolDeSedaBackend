package arboDeSeda.backend.Presentacion.DTOs.Cita;

import java.time.LocalDate;

public record CitaRegistroDTO (

        LocalDate fechaHora,

        int idPaciente,

        int idMedico
){
}
