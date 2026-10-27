package telas;

import java.util.*;
public class Menu {
    public static void mostrarInterface() {
        System.out.print("\n==============================================\n");
        System.out.print("                MENU PRINCIPAL");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Fazer Login\n"+
                            "2 - Realizar Cadastro\n"+
                            "3 - Visualizar Animais Disponíveis\n"+
                            "4 - Sobre o Sistema\n"+
                            "0 - Encerrar o Programa"
                        );
        
        System.out.println("\nEscolha uma opção :");
        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        int opcao = input.nextInt();
        while(opcao<0||opcao>4) {
            System.out.println("Opcao invalida! Tente novamente: ");
            System.out.print("> ");
            opcao = input.nextInt();
        }

        switch (opcao) {
            case 1:
                    TelaLogin.mostrarInterface();
            break;
            
            case 2:
                    TelaCadastroGenerico.mostrarInterface();
            break;

            default:
                break;
        }
        input.close();
    }
}