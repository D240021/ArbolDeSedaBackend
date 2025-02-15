package arboDeSeda.backend.Datos;

import arboDeSeda.backend.Dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    public Usuario findByNombreUsuario(String nombreUsuario);

    public boolean existsByNombreUsuario(String nombreUsuario);

}
