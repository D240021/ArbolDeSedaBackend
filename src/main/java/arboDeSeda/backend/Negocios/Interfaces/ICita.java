package arboDeSeda.backend.Negocios.Interfaces;

import arboDeSeda.backend.Dominio.Cita;

import java.util.List;

public interface ICita {

    public boolean agendarCita(Cita cita);

    public List<Cita> obtenerCitasPorUsuario(int idUsuario);
}
