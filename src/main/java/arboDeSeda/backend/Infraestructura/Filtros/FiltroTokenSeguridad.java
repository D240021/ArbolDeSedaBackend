package arboDeSeda.backend.Infraestructura.Filtros;


import arboDeSeda.backend.Datos.PacienteRepositorio;
import arboDeSeda.backend.Infraestructura.Seguridad.ServicioToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component
public class FiltroTokenSeguridad extends OncePerRequestFilter {

    @Autowired
    private final PacienteRepositorio pacienteRepositorio;

    @Autowired
    private final ServicioToken servicioToken;

    public FiltroTokenSeguridad(PacienteRepositorio pacienteRepositorio, ServicioToken servicioToken) {
        this.pacienteRepositorio = pacienteRepositorio;
        this.servicioToken = servicioToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest solicitud, HttpServletResponse respuesta, FilterChain filterChain) throws ServletException, IOException {
        // Get header's token
        var authHeader = solicitud.getHeader("Authorization");

        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var username = servicioToken.obtenerAsunto(token); // extract username

            if (username != null) {
                // Token valido
                var user = pacienteRepositorio.findByNombreUsuario(username);

                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication); // force login
            }
        }

        filterChain.doFilter(solicitud, respuesta);
    }
}
