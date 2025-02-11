package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Cita.CitaRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fechaHora;

    @OneToOne
    private Paciente paciente;

    private int idMedico;


    public Cita(CitaRegistroDTO citaRegistroDTO) {
        this.fechaHora = citaRegistroDTO.fechaHora();
        this.paciente.setId(citaRegistroDTO.idPaciente());
        this.idMedico = citaRegistroDTO.idMedico();
    }
}
