package usuario;

public interface IAutenticavel {
    boolean validarSenha(String senhaDigitada);
    int getId();
    String getUser();
    String getSenha();
}