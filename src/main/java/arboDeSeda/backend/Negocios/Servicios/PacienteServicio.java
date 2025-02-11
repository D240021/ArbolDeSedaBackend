package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.PacienteRepositorio;
import arboDeSeda.backend.Dominio.Paciente;
import arboDeSeda.backend.Negocios.Interfaces.IPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicio implements IPaciente {

    @Autowired
    private final PacienteRepositorio pacienteRepositorio;

    public PacienteServicio(PacienteRepositorio pacienteRepositorio) {
        this.pacienteRepositorio = pacienteRepositorio;
    }


    @Override
    public List<Paciente> obtenerTodosUsuarios() {
        return this.pacienteRepositorio.findAll();
    }

    @Override
    public Paciente obtenerUsuarioPorId(int id) {

        try {
            return this.pacienteRepositorio.findById(id)
                    .orElseThrow( () -> new Exception("Usuario no encontrado"));


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Paciente paciente) {
        try {
            pacienteRepositorio.save(paciente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
