package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Paciente;

import java.util.List;

public interface IPaciente {

    public List<Paciente> obtenerTodosUsuarios();

    public Paciente obtenerUsuarioPorId(int id);

    public boolean registrarUsuario(Paciente paciente);

}
