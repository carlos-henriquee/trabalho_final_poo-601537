package db;
import java.util.ArrayList;

import usuario.Voluntario;
public class Voluntarios {
    public static ArrayList<Voluntario> voluntarios = new ArrayList<Voluntario>();

    public static void adicionar(String nome, String nomeDeUsuario, String senha) {

        if(nome==null || nomeDeUsuario == null || senha==null)
            throw new IllegalArgumentException("CAMPOS NULOS");
        if(nome.equals("") || nomeDeUsuario.equals("") || senha.equals(""))
            throw new IllegalArgumentException("CAMPOS VAZIOS");
        if(senha.length()<6 || senha.length()>8)
            throw new IllegalArgumentException("SENHA INVALIDA!");


        Voluntario nv = new Voluntario(nome, nomeDeUsuario, senha);
        voluntarios.add(nv);
    }

    public static void mostrarVoluntarios() {
        System.out.print("\n====================================================\n");
        System.out.print("                VOLUNTARIOS CADASTRADOS");
        System.out.print("\n====================================================\n");
        for(Voluntario voluntario: voluntarios) {
            System.out.println(" - Nome: " + voluntario.nome);
        }
    }
    public static boolean validarVoluntario(String nomeDeUsuario, String senha){
        boolean encontrou = false;
        for(int i = 0;  i < voluntarios.size(); i++) {
            if(voluntarios.get(i).getUser().equals(nomeDeUsuario) && voluntarios.get(i).getSenha().equals(senha)) encontrou = true;
        }
        return encontrou;
    }
}
