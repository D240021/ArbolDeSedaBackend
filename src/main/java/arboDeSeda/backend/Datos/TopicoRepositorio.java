package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository<Topico,Integer> {
}
