package usuario;

public interface IAutenticavel {
    boolean validarSenha(String senhaDigitada);
    String getUser();
    String getSenha();
}