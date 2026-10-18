import Usuario.voluntario.Voluntario;
import Usuario.voluntario.Voluntario.ListaDeVoluntarios;

import java.util.*;

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