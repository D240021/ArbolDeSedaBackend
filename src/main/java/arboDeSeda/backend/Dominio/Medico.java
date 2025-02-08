package arboDeSeda.backend.Dominio;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Medico extends Usuario{

    private String especialidad;
    private String horario;
}
