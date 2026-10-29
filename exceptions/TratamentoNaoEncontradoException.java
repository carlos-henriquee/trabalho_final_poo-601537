package exceptions;

public class TratamentoNaoEncontradoException extends Exception {
    public TratamentoNaoEncontradoException() {
        super();
    }
    public TratamentoNaoEncontradoException(String msg) {
        super(msg);
    }
}
