package classes_utilitarias;

public class Notificacao {
    private String msg;

    public Notificacao(String msg)
        throws IllegalArgumentException
    {
        if(msg==null || msg.equals(""))
            throw new IllegalArgumentException("MENSAGEM NULA OU VAZIA!");
        if(msg.length()>30)
            throw new IllegalArgumentException("MENSAGEM MUITO GRANDE!");


        this.msg = msg;
    }

    public String getNotificacaoMessage() {
        return this.msg;
    }
}

