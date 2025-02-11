package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Comentario;

import java.util.List;

public interface IComentario{

    public boolean registrarComentario(Comentario comentario);

    public boolean actualizarComentario(Comentario comentario);

    public List<Comentario> obtenerComentariosPorTopico(int idTopico);
}
