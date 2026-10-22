package usuario;

public class Voluntario extends Usuario{
    public Voluntario (String nome, String nomeDeUsuario, String senha) 
        throws IllegalArgumentException 
    {
        super(nome, nomeDeUsuario, senha);
    }
}
