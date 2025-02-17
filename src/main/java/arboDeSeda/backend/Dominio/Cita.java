package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Cita.CitaRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fechaHora;

    @OneToOne
    private Usuario usuario;

    private int idMedico;

    public Cita(){}

    public Cita(CitaRegistroDTO citaRegistroDTO) {

        this.usuario = new Usuario();

        this.fechaHora = citaRegistroDTO.fechaHora();
        this.usuario.setId(citaRegistroDTO.idPaciente());
        this.idMedico = citaRegistroDTO.idMedico();
    }
}
