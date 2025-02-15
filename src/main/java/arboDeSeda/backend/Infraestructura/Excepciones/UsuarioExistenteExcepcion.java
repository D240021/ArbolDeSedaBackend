package arboDeSeda.backend.Infraestructura.Excepciones;

public class UsuarioExistenteExcepcion extends RuntimeException {
    public UsuarioExistenteExcepcion(String message) {
        super(message);
    }
}
