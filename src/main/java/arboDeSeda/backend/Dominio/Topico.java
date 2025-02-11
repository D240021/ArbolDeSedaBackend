package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Topico.TopicoRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Foro")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String asunto;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public Topico(TopicoRegistroDTO topicoRegistroDTO) {
        this.asunto = topicoRegistroDTO.asunto();
        this.contenido = topicoRegistroDTO.contenido();
        this.paciente.setId(topicoRegistroDTO.idPaciente());
    }
}
