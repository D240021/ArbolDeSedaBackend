package arboDeSeda.backend.Dominio;

import arboDeSeda.backend.Presentacion.DTOs.Usuario.AutenticacionDTO;
import arboDeSeda.backend.Presentacion.DTOs.Usuario.UsuarioRegistroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario implements UserDetails {

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }
}
