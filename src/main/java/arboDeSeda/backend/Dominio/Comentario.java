package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioActualizacionDTO;
import arboDeSeda.backend.Presentacion.DTOs.Comentario.ComentarioRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    private LocalDate fecha;
    private String contenido;

    public Comentario(){}

    public Comentario(ComentarioRegistroDTO comentarioRegistroDTO) {

        this.usuario = new Usuario();
        this.topico = new Topico();

        this.usuario.setId(comentarioRegistroDTO.idUsuario());
        this.topico.setId(comentarioRegistroDTO.idTopico());
        this.fecha = comentarioRegistroDTO.fechaHora();
        this.contenido = comentarioRegistroDTO.contenido();
    }

    public Comentario(ComentarioActualizacionDTO comentarioActualizacionDTO) {
        this.contenido = comentarioActualizacionDTO.contenido();
    }


}
