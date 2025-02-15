package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Usuario.AutenticacionDTO;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String contrasenia;
    private String especialidad;
    private String pais;
    private String tipo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topicos;

    public Usuario(){

    }

    public Usuario(UsuarioRegistroDTO usuarioRegistroDTO){
        this.nombreUsuario = usuarioRegistroDTO.nombreUsuario();
        this.nombre = usuarioRegistroDTO.nombre();
        this.apellidos = usuarioRegistroDTO.apellidos();
        this.telefono = usuarioRegistroDTO.telefono();
        this.correo = usuarioRegistroDTO.correo();
        this.contrasenia = usuarioRegistroDTO.contrasenia();
        this.especialidad = usuarioRegistroDTO.especialidad();
        this.pais = usuarioRegistroDTO.pais();
        this.tipo = usuarioRegistroDTO.tipo();
    }

    public Usuario(AutenticacionDTO autenticacionDTO) {
        this.nombreUsuario = autenticacionDTO.nombreUsuario();
        this.contrasenia = autenticacionDTO.contrasenia();
    }
}
