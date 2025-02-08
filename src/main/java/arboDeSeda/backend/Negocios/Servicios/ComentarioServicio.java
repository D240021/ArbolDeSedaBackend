package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.ComentarioRepositorio;
import arboDeSeda.backend.Datos.TopicoRepositorio;
import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Negocios.Interfaces.IComentario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

public class ComentarioServicio implements IComentario {

    @Autowired
    private final ComentarioRepositorio comentarioRepositorio;

    @Autowired
    private final TopicoRepositorio topicoRepositorio;

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    public ComentarioServicio(ComentarioRepositorio comentarioRepositorio, TopicoRepositorio topicoRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.comentarioRepositorio = comentarioRepositorio;
        this.topicoRepositorio = topicoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public boolean registrarComentario(Comentario comentario) {

        try{

            if(!this.usuarioRepositorio.existsById(comentario.getUsuario().getId()))
                throw new Exception("Usuario no encontrado");

            if (!this.topicoRepositorio.existsById(comentario.getTopico().getId()))
                throw new Exception("Topico no encontrado");

            this.comentarioRepositorio.save(comentario);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Modifying
    @Transactional
    @Override
    public boolean actualizarComentario(Comentario comentario) {
        try {
            Comentario comentarioBaseDatos = this.comentarioRepositorio
                    .findById(comentario.getId())
                    .orElseThrow(() -> new Exception("Comentario no encontrado"));

            comentarioBaseDatos.setContenido(comentario.getContenido());
            comentarioBaseDatos.setFecha(comentario.getFecha());

            comentarioRepositorio.save(comentarioBaseDatos);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
