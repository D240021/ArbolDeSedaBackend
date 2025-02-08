package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Usuario;

import java.util.List;

public interface IUsuario {

    public List<Usuario> obtenerTodosUsuarios();

    public Usuario obtenerUsuarioPorId(int id);

    public boolean registrarUsuario(Usuario usuario);

}
