package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Usuario.PacienteRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cedula;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String contrasenia;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Paciente(){

    }

    public Paciente(PacienteRegistroDTO pacienteRegistroDTO){
        this.cedula = pacienteRegistroDTO.cedula();
        this.nombre = pacienteRegistroDTO.nombre();
        this.apellidos = pacienteRegistroDTO.apellidos();
        this.telefono = pacienteRegistroDTO.telefono();
        this.correo = pacienteRegistroDTO.correo();
        this.contrasenia = pacienteRegistroDTO.contrasenia();
    }
}
