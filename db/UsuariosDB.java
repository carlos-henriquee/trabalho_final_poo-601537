package db;
import java.util.ArrayList;
import telas.admin.TelaAdmin;
import usuario.Usuario;
import usuario.Veterinario;
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
        usuariosCadastrados.add(u);
        System.out.println("USUARIO CADASTRADO COM SUCESSO!");
    }
    public static void removerUsuario(Usuario user) {
        usuariosCadastrados.remove(user);
    }
    public static Usuario validarUsuarioPorId(int id) {
        if(usuariosCadastrados.size()==0){
            return null;
        }
        for(Usuario user: usuariosCadastrados) {
            if(user.getId()==id) {
                return user;
            }
        }
        return null;
    }
    public static Usuario validarVoluntarioPorNome(String nomeVoluntario) {
        if(usuariosCadastrados.size()==0)
            return null;
        else{
            for(Usuario usuario: usuariosCadastrados) {
                if(usuario instanceof Voluntario && usuario.nome.toLowerCase().trim().equals(nomeVoluntario.toLowerCase().trim()))
                    return usuario;
            }
        }
        return null;
    }
    public static void mostrarUsuarios() {
        System.out.print("\n====================================================\n");
        System.out.print("                USUARIOS CADASTRADOS");
        System.out.print("\n====================================================\n");

        if(usuariosCadastrados.size()==0) {
            System.out.println("TABELA VAZIA!");
            TelaAdmin.mostrarInterface();
        }else{
            String cargo = "USUARIO";
            for(Usuario usuario: usuariosCadastrados) {
                if(usuario instanceof Veterinario) cargo = "VETERINARIO";
                else if(usuario instanceof Voluntario) cargo  = "VOLUNTARIO";
                System.out.println( " - ID: " + usuario.getId() + 
                                    " | Nome: " + usuario.nome + 
                                    " | Cargo: " + cargo);
            }
        }
        
    }
    public static Usuario logar(String nomeDeUsuario, String senha) 
        throws IllegalArgumentException
    {
        if(nomeDeUsuario==null || senha==null)
            throw new IllegalArgumentException("CAMPOS NULOS!");
        if(nomeDeUsuario.equals("") || senha.equals(""))
            throw new IllegalArgumentException("CAMPOS VAZIOS!");
    
        boolean encontrou = false;
        int i = 0;

        while(encontrou==false && i < usuariosCadastrados.size()) {
            if(
                usuariosCadastrados.get(i).getUser().equals(nomeDeUsuario) && 
                usuariosCadastrados.get(i).getSenha().equals(senha)
            ) {
                encontrou = true;
                return usuariosCadastrados.get(i);

            }
            i++;
        }
        System.out.println("USUARIO OU SENHA INCORRETOS!");
        return null;
    }
    public static void mostrarVoluntarios() {
        System.out.print("\n====================================================\n");
        System.out.print("                VOLUNTARIOS CADASTRADOS");
        System.out.print("\n====================================================\n");
        if(usuariosCadastrados.size()==0){
            System.out.println("SEM VOLUNTARIOS!");
            return;
        }
        for(Usuario user : usuariosCadastrados) {
            if(user instanceof Voluntario) {
                System.out.println("- ID: "+ user.getId()+ " | Nome: " + user.nome);
            }
        }
    }
}
