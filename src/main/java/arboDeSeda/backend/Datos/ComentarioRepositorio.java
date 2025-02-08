package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {
}
