package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Infraestructura.Seguridad.ServicioToken;
import arboDeSeda.backend.Negocios.Interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuario {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Value("${api.security.secret}")
    private String apiSecret;

    @Autowired
    private final ServicioToken servicioToken;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, AuthenticationManager authenticationManager, ServicioToken servicioToken) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.authenticationManager = authenticationManager;
        this.servicioToken = servicioToken;
    }


    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {

        try {
            return this.usuarioRepositorio.findById(id)
                    .orElseThrow( () -> new Exception("Usuario no encontrado"));


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {
            usuarioRepositorio.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String obtenerJWToken(Usuario usuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(),
                usuario.getPassword());

        Usuario authenticateUser = (Usuario) authenticationManager.authenticate(authenticationToken).getPrincipal();


        return  servicioToken.generarTokenJWT(authenticateUser);
    }

    @Override
    public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {

        try {

            Usuario usuario = (Usuario) this.usuarioRepositorio.findByNombreUsuario(nombreUsuario);

            if(usuario == null)
                throw new Exception("Usuario no encontrado");

            return usuario;

        }catch (Exception e){
            return null;
        }

    }
}
