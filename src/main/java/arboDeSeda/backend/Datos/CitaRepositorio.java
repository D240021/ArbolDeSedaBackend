package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepositorio extends JpaRepository<Cita,Integer> {

    List<Cita> findByPaciente(Usuario paciente);
}
