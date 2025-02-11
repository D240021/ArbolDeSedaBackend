package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.ComentarioRepositorio;
import arboDeSeda.backend.Datos.TopicoRepositorio;
import arboDeSeda.backend.Datos.PacienteRepositorio;
import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Dominio.Topico;
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
    private final PacienteRepositorio pacienteRepositorio;

    public ComentarioServicio(ComentarioRepositorio comentarioRepositorio, TopicoRepositorio topicoRepositorio, PacienteRepositorio pacienteRepositorio) {
        this.comentarioRepositorio = comentarioRepositorio;
        this.topicoRepositorio = topicoRepositorio;
        this.pacienteRepositorio = pacienteRepositorio;
    }

    @Override
    public boolean registrarComentario(Comentario comentario) {

        try{

            if(!this.pacienteRepositorio.existsById(comentario.getPaciente().getId()))
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
                    .orElseThrow( () -> new Exception("Topico no encontrado") );

            return this.comentarioRepositorio.findByTopico(topicoBuscado);
        }catch (Exception e){
            return List.of();
        }

    }

}
