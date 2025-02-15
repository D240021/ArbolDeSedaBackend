package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Usuario;
import arboDeSeda.backend.Infraestructura.Excepciones.AutenticacionExcepcion;
import arboDeSeda.backend.Infraestructura.Excepciones.NoEncontradoExcepcion;
import arboDeSeda.backend.Infraestructura.Excepciones.UsuarioExistenteExcepcion;
import arboDeSeda.backend.Negocios.Interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
                    .orElseThrow( () -> new NoEncontradoExcepcion("Usuario no encontrado"));


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {

            if(this.usuarioRepositorio.existsByNombreUsuario(usuario.getNombreUsuario()))
                throw new UsuarioExistenteExcepcion("Usuario ya registrado");

            usuarioRepositorio.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Usuario autenticarUsuario(Usuario usuario) {

        Usuario usuarioBaseDatos = this.usuarioRepositorio.findByNombreUsuario(usuario.getNombreUsuario());

        if(usuarioBaseDatos == null)
            throw new NoEncontradoExcepcion("Usuario no encontrado");

        if(!Objects.equals(usuario.getNombreUsuario(), usuarioBaseDatos.getNombreUsuario()) ||
                    !Objects.equals(usuario.getContrasenia(), usuarioBaseDatos.getContrasenia()))
            throw new AutenticacionExcepcion("Error de autenticacion");

        return usuarioBaseDatos;

    }

    @Override
    public boolean existeUsuario(String nombreUsuario) {
        return this.usuarioRepositorio.existsByNombreUsuario(nombreUsuario);
    }
}
