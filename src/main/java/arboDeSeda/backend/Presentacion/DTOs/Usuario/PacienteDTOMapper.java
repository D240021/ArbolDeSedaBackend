package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import arboDeSeda.backend.Dominio.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteDTOMapper {

    public static List<PacienteLecturaDTO> convertirUsuariosAUsuariosLecturaDTO(List<Paciente> pacientes){
        return pacientes.stream()
                .map(PacienteLecturaDTO::new)
                .collect(Collectors.toList());
    }

    public static PacienteLecturaDTO convertirUsuarioAUsuarioLecturaDTO(Paciente paciente){
        return new PacienteLecturaDTO(paciente);
    }

    public static Paciente convertirUsuarioRegistroDTOAUsuario(PacienteRegistroDTO pacienteRegistroDTO){
        return new Paciente(pacienteRegistroDTO);
    }
}
