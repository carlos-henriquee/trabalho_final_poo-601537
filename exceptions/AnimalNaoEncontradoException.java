package exceptions;

public class AnimalNaoEncontradoException extends Exception {
    public AnimalNaoEncontradoException() {
        super();
    }
    public AnimalNaoEncontradoException(String msg) {
        super(msg);
    }
}
