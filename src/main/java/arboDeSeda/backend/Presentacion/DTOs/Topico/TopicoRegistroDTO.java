package arboDeSeda.backend.Presentacion.DTOs.Topico;

import arboDeSeda.backend.Dominio.Paciente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record TopicoRegistroDTO(

         String asunto,
         String contenido,
         int idPaciente
) {
}
