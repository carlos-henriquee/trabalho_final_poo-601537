package views.veterinario;
import java.util.Scanner;

import db.UsuariosDB;
import views.Menu;
import views.admin.TelaAdmin;
import views.voluntario.CadastroVoluntario;
public class PainelVeterinario {
    public void mostrarInterface() {
        System.out.print("\n==============================================\n");
        System.out.print("                ÁREA DO VETERINÁRIO");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Consultar Animais\n"+
                            "2 - Registrar Atendimento\n"+
                            "3 - Atualizar Tratamento\n"+
                            "4 - Registrar Vacinação\n"+
                            "5 - Emitir Relatório Médico\n" +
                            "7 - Notificações\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opção: ");
        Scanner entrada = new Scanner(System.in);
        System.out.print("> ");
        int opcao = entrada.nextInt();

        while(opcao<0 || opcao>7) {
            System.out.println("Opção inválida! Digite novamente!");
            System.out.print("> ");
            opcao = entrada.nextInt();
        }

        while(opcao!= 0 ) {
            switch(opcao) {
            
                case 1: 
                    CadastroVoluntario.mostrarInterface();
                break;
                case 2:
                    CadastroVoluntario.mostrarInterface();
                break;
                case 3:
                    Scanner inputLogin = new Scanner(System.in);
                    System.out.print("\nNome de usuario: ");
                    String user = inputLogin.nextLine();

                    System.out.print("\nSenha: ");
                    String senha = inputLogin.nextLine();

                    if(user.equals("admin") && senha.equals("admin"))
                        TelaAdmin.mostrarInterface();
                    UsuariosDB.logar(user, senha);
                    inputLogin.close();
                break;
                default:
                break;
            }
            Menu.mostrarInterface();
            entrada.close();
        }
    }


        
}
