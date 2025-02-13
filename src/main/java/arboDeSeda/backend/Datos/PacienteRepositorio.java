package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface PacienteRepositorio extends JpaRepository<Paciente,Integer> {

    public UserDetails findByNombreUsuario(String nombreUsuario);

}
