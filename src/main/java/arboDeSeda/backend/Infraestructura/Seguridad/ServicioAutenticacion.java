package arboDeSeda.backend.Infraestructura.Seguridad;

import arboDeSeda.backend.Datos.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion implements UserDetailsService {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    public ServicioAutenticacion(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        return this.usuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }
}
