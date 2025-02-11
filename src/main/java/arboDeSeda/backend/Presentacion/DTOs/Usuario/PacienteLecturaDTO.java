package arboDeSeda.backend.Presentacion.DTOs.Usuario;

import arboDeSeda.backend.Dominio.Paciente;

public record PacienteLecturaDTO(

         Integer id,
         String cedula,
         String nombre,
         String apellidos,
         String telefono,
         String correo

) {

    public PacienteLecturaDTO(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getCedula(),
                paciente.getNombre(),
                paciente.getApellidos(),
                paciente.getTelefono(),
                paciente.getCorreo()
        );
    }
}
