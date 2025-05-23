package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.ComentarioRepositorio;
import arboDeSeda.backend.Datos.TopicoRepositorio;
import arboDeSeda.backend.Datos.UsuarioRepositorio;
import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Dominio.Topico;
import arboDeSeda.backend.Infraestructura.Excepciones.NoEncontradoExcepcion;
import arboDeSeda.backend.Negocios.Interfaces.IComentario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
                throw new NoEncontradoExcepcion("Usuario no encontrado");

            if (!this.topicoRepositorio.existsById(comentario.getTopico().getId()))
                throw new NoEncontradoExcepcion("Topico no encontrado");

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
                    .orElseThrow(() -> new NoEncontradoExcepcion("Comentario no encontrado"));

            comentarioBaseDatos.setContenido(comentario.getContenido());

            comentarioRepositorio.save(comentarioBaseDatos);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Comentario> obtenerComentariosPorTopico(int idTopico) {

        try{
            Topico topicoBuscado = this.topicoRepositorio.findById(idTopico)
                    .orElseThrow( () -> new NoEncontradoExcepcion("Topico no encontrado") );

            return this.comentarioRepositorio.findByTopico(topicoBuscado);
        }catch (Exception e){
            return List.of();
        }

    }

}
