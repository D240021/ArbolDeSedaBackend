package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente,Integer> {
}
