package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Usuario;

import java.util.List;

public interface IUsuario <T extends Usuario> {

    public List<T> obtenerTodosUsuarios();

    public T obtenerUsuarioPorId(int id);

    public boolean registrarUsuario(T usuario);

}
