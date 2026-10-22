package menu;

import java.util.Scanner;

import db.Voluntarios;

public class CadastroVoluntario {
    public static void mostrarInterface() {
        System.out.print("\n==================================================\n");
        System.out.print("           TELA DE CADASTRO DE VOLUNTARIOS            ");
        System.out.print("\n==================================================\n");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu nome de usuário: ");
        String nomeDeUsuario = entrada.nextLine();


        System.out.println("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
        System.out.print("> ");
        String senha = entrada.nextLine();

        Voluntarios.adicionar(nome, nomeDeUsuario, senha);
        entrada.close();
        
    }

}
