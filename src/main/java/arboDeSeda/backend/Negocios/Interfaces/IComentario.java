package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Comentario;

public interface IComentario{

    public boolean registrarComentario(Comentario comentario);

    public boolean actualizarComentario(Comentario comentario);
}
