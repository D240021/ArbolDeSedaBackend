package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cedula;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String contrasenia;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Usuario(){

    }

    public Usuario(UsuarioRegistroDTO usuarioRegistroDTO){
        this.cedula = usuarioRegistroDTO.cedula();
        this.nombre = usuarioRegistroDTO.nombre();
        this.apellidos = usuarioRegistroDTO.apellidos();
        this.telefono = usuarioRegistroDTO.telefono();
        this.correo = usuarioRegistroDTO.correo();
        this.contrasenia = usuarioRegistroDTO.contrasenia();
    }
}
