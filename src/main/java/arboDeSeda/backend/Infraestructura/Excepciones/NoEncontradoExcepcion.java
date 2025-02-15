package arboDeSeda.backend.Infraestructura.Excepciones;

public class NoEncontradoExcepcion extends RuntimeException {
    public NoEncontradoExcepcion(String message) {
        super(message);
    }
}
