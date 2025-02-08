package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico,Integer> {
}
