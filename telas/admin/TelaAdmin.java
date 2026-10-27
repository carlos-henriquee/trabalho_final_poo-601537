package telas.admin;

import java.util.Scanner;

import telas.Menu;
import db.UsuariosDB;
public class TelaAdmin {
    public static void mostrarInterface() {
        System.out.print("\n==============================================\n");
        System.out.print("                PAINEL DE ADMINISTRAÇÃO");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Gerenciar Animais\n"+
                            "2 - Gerenciar Usuarios\n"+
                            "3 - Aprovar Adoções\n"+
                            "4 - Gerenciar Eventos\n"+
                            "5 - Relatórios\n" +
                            "6 - Estatísticas\n" +
                            "7 - Notificações\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opcao: ");
        Scanner entrada = new Scanner(System.in);
        System.out.print("> ");
        int opcao = entrada.nextInt();
        while(opcao<0||opcao>7) {
            System.out.println("Opção inválida! Digite novamente!");
            System.out.print("> ");
            opcao = entrada.nextInt();
        }
        
            switch(opcao) {
                case 0:
                    Menu.mostrarInterface();
                break;
                case 1: 
                    TelaGestaoAnimais.mostrarInterface();
                break;

                case 2:
                    UsuariosDB.mostrarUsuarios();
                break;
                default:
                    break;
            }
        
        Menu.mostrarInterface();
        entrada.close();
    }
}
