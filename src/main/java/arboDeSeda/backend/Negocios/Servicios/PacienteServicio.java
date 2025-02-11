package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Negocios.Interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuario {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {

        try {
            return this.usuarioRepositorio.findById(id)
                    .orElseThrow( () -> new Exception("Usuario no encontrado"));


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {
            usuarioRepositorio.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
