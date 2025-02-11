package arboDeSeda.backend.Presentacion.DTOs.Comentario;

import arboDeSeda.backend.Dominio.Comentario;

import java.time.LocalDate;

public record ComentarioLecturaDTO (

        int id,
        int pacienteId,
        LocalDate fechaHora,
        String contenido
) {
    public ComentarioLecturaDTO(Comentario comentario) {
        this(comentario.getId(),comentario.getPaciente().getId(),comentario.getFecha(),comentario.getContenido());
    }
}
