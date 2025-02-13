package arboDeSeda.backend.Infraestructura.Seguridad;

import arboDeSeda.backend.Datos.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion implements UserDetailsService {

    @Autowired
    private final PacienteRepositorio pacienteRepositorio;

    public ServicioAutenticacion(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        return this.pacienteRepositorio.findByNombreUsuario(nombreUsuario);
    }
}
