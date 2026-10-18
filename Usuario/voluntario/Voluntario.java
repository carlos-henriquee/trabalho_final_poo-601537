package Usuario.voluntario;

import java.util.ArrayList;

import Usuario.Usuario;

public class Voluntario extends Usuario{
    public Voluntario (String nome, String nomeDeUsuario, String senha) {
        super(nome, nomeDeUsuario, senha);
    }

    public static class ListaDeVoluntarios {
        public static ArrayList<Voluntario> voluntarios = new ArrayList<Voluntario>();
        public static void inserirVoluntario(String nome, String nomeDeUsuario, String senha) {
            Voluntario v = new Voluntario(nome, nomeDeUsuario, senha);
            voluntarios.add(v);
        }
        public static void mostrarVoluntarios() {
            for(Voluntario v: voluntarios) {
                System.out.println("////////////////\nNome: " + v.nome + "\n///////////////\n");
            }
        }
    }
}
