package usuario;

public abstract class Usuario implements IAutenticavel{
    public String nome;
    private String nomeDeUsuario;
    private String senha;

    public Usuario (String nome, String nomeDeUsuario, String senha) throws IllegalArgumentException{
            if(
                (nome==null||nomeDeUsuario==null||senha==null) || 
                (nome.equals("") || nomeDeUsuario.equals("") || senha.equals(""))
            ){
                throw new IllegalArgumentException("Existem campos nulos ou vazios!");
            }
            this.nome = nome;
            this.nomeDeUsuario = nomeDeUsuario;
            this.senha = senha;
    }

    @Override
    public String getUser() {
        return this.nomeDeUsuario;
    }
    @Override
    public String getSenha() {
        return this.senha;
    }
    @Override
    public boolean validarSenha(String senhaDigitada) {
        return this.getSenha().equals(senhaDigitada);
    }
}
