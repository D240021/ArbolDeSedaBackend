package arboDeSeda.backend.Presentacion.DTOs.Cita;

import java.time.LocalDate;
import java.util.Date;

public record CitaRegistroDTO (

        Date fechaHora,

        int idPaciente,

        int idMedico
){
}
