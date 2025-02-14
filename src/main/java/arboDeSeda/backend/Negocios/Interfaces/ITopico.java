package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Comentario;
import arboDeSeda.backend.Dominio.Topico;

import java.util.List;

public interface ITopico {

    public boolean registrarTopico(Topico topico);

    public List<Topico> obtenerTodosTopicos();
}
