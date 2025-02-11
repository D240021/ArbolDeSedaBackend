package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Dominio.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {

    public List<Comentario> findByTopico(Topico topico);
}
