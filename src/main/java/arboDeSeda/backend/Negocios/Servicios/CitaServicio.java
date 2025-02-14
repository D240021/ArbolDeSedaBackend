package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.CitaRepositorio;
import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Negocios.Interfaces.ICita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServicio implements ICita {

    @Autowired
    private final CitaRepositorio citaRepositorio;

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    public CitaServicio(CitaRepositorio citaRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.citaRepositorio = citaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public boolean agendarCita(Cita cita) {

        try {

            if(!this.usuarioRepositorio.existsById(cita.getUsuario().getId()))
                throw new Exception("Usuario no encontrado");

            this.citaRepositorio.save(cita);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<Cita> obtenerCitasPorUsuario(int idPaciente) {

        try {

            Usuario usuario = this.usuarioRepositorio.findById(idPaciente)
                    .orElseThrow( () -> new Exception("Usuario no encontrado") );

            return this.citaRepositorio.findByUsuario(usuario);

        }catch (Exception e){
            return List.of();
        }
    }
}
