package arboDeSeda.backend.Infraestructura.Excepciones;

import arboDeSeda.backend.Presentacion.DTOs.Errores.MensajeErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejarExcepciones {

    @ExceptionHandler(AutenticacionExcepcion.class)
    public ResponseEntity<MensajeErrorDTO> manejarAutenticacionExcepcion(){
        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(new MensajeErrorDTO("Error en autenticacion"));
    }

    @ExceptionHandler(UsuarioExistenteExcepcion.class)
    public ResponseEntity<MensajeErrorDTO> manejarUsuarioExistenteExcepcion(){
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).body(new MensajeErrorDTO("Usuario ya está registrado"));
    }

    @ExceptionHandler(NoEncontradoExcepcion.class)
    public ResponseEntity<MensajeErrorDTO> manejarNoEncontradoExcepcion( NoEncontradoExcepcion e ){
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(new MensajeErrorDTO(e.getMessage()));
    }

}
