package arboDeSeda.backend.Presentacion.DTOs.Cita;

import arboDeSeda.backend.Dominio.Cita;

import java.util.List;
import java.util.stream.Collectors;

public class CitaDTOMapper {

    public static Cita convertirCitaRegistroDTOACita(CitaRegistroDTO citaRegistroDTO){
        return new Cita(citaRegistroDTO);
    }

    public static List<CitaLecturaDTO> convertirCitasACitasLecturaDTO(List<Cita> citas){
        return citas.stream()
                .map(CitaLecturaDTO::new)
                .collect(Collectors.toList());
    }
}
