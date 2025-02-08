package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.MedicoRepositorio;
import arboDeSeda.backend.Datos.PacienteRepositorio;
import arboDeSeda.backend.Dominio.Medico;
import arboDeSeda.backend.Dominio.Paciente;
import arboDeSeda.backend.Negocios.Interfaces.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServicio implements IUsuario<Medico> {

    @Autowired
    private final MedicoRepositorio medicoRepositorio;


    public MedicoServicio(MedicoRepositorio medicoRepositorio) {
        this.medicoRepositorio = medicoRepositorio;
    }


    @Override
    public List<Medico> obtenerTodosUsuarios() {
        return this.medicoRepositorio.findAll();
    }

    @Override
    public Medico obtenerUsuarioPorId(int id) {

        try {
            return this.medicoRepositorio.findById(id)
                    .orElseThrow( () -> new Exception("Paciente no encontrado"));


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Medico medico) {
        try {
            this.medicoRepositorio.save(medico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
