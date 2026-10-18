package usuario;

public abstract class Usuario {
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

}
