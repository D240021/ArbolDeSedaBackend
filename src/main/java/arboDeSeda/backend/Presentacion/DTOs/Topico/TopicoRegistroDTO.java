package arboDeSeda.backend.Presentacion.DTOs.Topico;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record TopicoRegistroDTO(

         @NotBlank
         String asunto,
         @NotBlank
         String contenido,
         @Range(min = 1)
         int idUsuario
) {
}
