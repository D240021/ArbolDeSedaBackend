package arboDeSeda.backend.Presentacion.DTOs.Comentario;

import java.time.LocalDate;

public record ComentarioRegistroDTO(

        int idPaciente,
        int idTopico,
        LocalDate fechaHora,
        String contenido
) {
}
