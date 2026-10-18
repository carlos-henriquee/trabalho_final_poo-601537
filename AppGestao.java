import java.util.*;

import usuario.voluntario.Voluntario;
import usuario.voluntario.Voluntario.ListaDeVoluntarios;

public class AppGestao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite um nome de usuario: ");
        String nomeDeUsuario = entrada.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = entrada.nextLine();

        try{
            ListaDeVoluntarios.inserirVoluntario(nome, nomeDeUsuario, senha);
            ListaDeVoluntarios.mostrarVoluntarios();
        }catch(IllegalArgumentException i) {
            System.out.println("HOUVE UM ERRO: " + i.getMessage());
        }finally{
            entrada.close();
        }


    }
}