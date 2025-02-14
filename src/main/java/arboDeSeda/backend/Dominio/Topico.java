package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Topico.TopicoRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String asunto;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public Topico(){

    }

    public Topico(TopicoRegistroDTO topicoRegistroDTO) {

        this.usuario = new Usuario();

        this.asunto = topicoRegistroDTO.asunto();
        this.contenido = topicoRegistroDTO.contenido();
        this.usuario.setId(topicoRegistroDTO.idUsuario());
    }
}
