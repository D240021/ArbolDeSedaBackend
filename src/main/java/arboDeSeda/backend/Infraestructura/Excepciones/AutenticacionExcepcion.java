package arboDeSeda.backend.Infraestructura.Excepciones;

public class AutenticacionExcepcion extends RuntimeException {
    public AutenticacionExcepcion(String message) {
        super(message);
    }
}
