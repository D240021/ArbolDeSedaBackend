package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.TopicoRepositorio;
import arboDeSeda.backend.Dominio.Topico;
import arboDeSeda.backend.Negocios.Interfaces.ITopico;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicoServicio implements ITopico {

    @Autowired
    private final TopicoRepositorio topicoRepositorio;

    public TopicoServicio(TopicoRepositorio topicoRepositorio) {
        this.topicoRepositorio = topicoRepositorio;
    }

    @Override
    public boolean registrarTopico(Topico topico) {

        try {
            this.topicoRepositorio.save(topico);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
