package db;
import java.util.ArrayList;

import usuario.Usuario;
import usuario.Voluntario;


public class UsuariosDB {
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();

    public static void cadastrar(Usuario u) 
        throws IllegalArgumentException
    {

        if(u.nome==null || u.getUser() == null || u.getSenha()==null)
            throw new IllegalArgumentException("CAMPOS NULOS");
        if(u.nome.equals("") || u.getUser().equals("") || u.getSenha().equals(""))
            throw new IllegalArgumentException("CAMPOS VAZIOS");
        if(u.getSenha().length()<6 || u.getSenha().length()>8)
            throw new IllegalArgumentException("SENHA INVALIDA!");
        if(u instanceof Voluntario) {
            
        }
    }

    public static void mostrarVoluntarios() {
        System.out.print("\n====================================================\n");
        System.out.print("                VOLUNTARIOS CADASTRADOS");
        System.out.print("\n====================================================\n");
        for(Usuario voluntario: usuariosCadastrados) {
            if(voluntario instanceof Voluntario)
                System.out.println(" - Nome: " + voluntario.nome);
        }
    }
    public static boolean logar(String nomeDeUsuario, String senha) 
        throws IllegalArgumentException
    {
        if(nomeDeUsuario==null || senha==null)
            throw new IllegalArgumentException("CAMPOS NULOS!");
        if(nomeDeUsuario.equals("") || senha.equals(""))
            throw new IllegalArgumentException("CAMPOS VAZIOS!");
    
        boolean encontrou = false;
        for(int i = 0;  i < usuariosCadastrados.size(); i++) {
            if(
                usuariosCadastrados.get(i).getUser().equals(nomeDeUsuario) && 
                usuariosCadastrados.get(i).getSenha().equals(senha)
            ) encontrou = true;
        }
        return encontrou;
    }
}
