package arboDeSeda.backend.Negocios.Servicios;

import arboDeSeda.backend.Datos.CitaRepositorio;
import arboDeSeda.backend.Datos.PacienteRepositorio;
import arboDeSeda.backend.Dominio.Cita;
import arboDeSeda.backend.Dominio.Paciente;
import arboDeSeda.backend.Negocios.Interfaces.ICita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServicio implements ICita {

    @Autowired
    private final CitaRepositorio citaRepositorio;

    @Autowired
    private final PacienteRepositorio pacienteRepositorio;

    public CitaServicio(CitaRepositorio citaRepositorio, PacienteRepositorio pacienteRepositorio) {
        this.citaRepositorio = citaRepositorio;
        this.pacienteRepositorio = pacienteRepositorio;
    }

    @Override
    public boolean agendarCita(Cita cita) {

        try {

            if(this.pacienteRepositorio.existsById(cita.getPaciente().getId()))
                throw new Exception("Paciente no encontrado");

            this.citaRepositorio.save(cita);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<Cita> obtenerCitasPorUsuario(int idPaciente) {

        try {

            Paciente paciente = this.pacienteRepositorio.findById(idPaciente)
                    .orElseThrow( () -> new Exception("Paciente no encontrado") );

            return this.citaRepositorio.findByPaciente(paciente);

        }catch (Exception e){
            return List.of();
        }
    }
}
