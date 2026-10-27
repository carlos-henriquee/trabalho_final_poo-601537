package telas.veterinario;
import java.util.Scanner;

import db.UsuariosDB;
import telas.Menu;
import telas.admin.TelaAdmin;
import telas.voluntario.CadastroVoluntario;
public class PainelVeterinario {
    public static void mostrarInterface(String nomeVeterinario) {
        System.out.print("\n==============================================\n");
        System.out.print("                ÁREA DO VETERINÁRIO");
        System.out.print("\n==============================================\n");
        System.out.println("Bem-vindo, " + nomeVeterinario + "! O que deseja fazer?");
        System.out.println( "1 - Ver animais cadastrados\n"+
                            "2 - Ver consultas cadastradas\n" +
                            "3 - Cadastrar animal\n" +
                            "4 - Cadastrar consulta\n" +
                            "5 - Cadastrar tratamento\n" +
                            "6 - Atualizar Tratamento\n"+
                            "7 - Registrar Vacinação\n"+
                            "8 - Emitir Relatório Médico\n" +
                            "9 - Notificações\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opção: ");
        Scanner entrada = new Scanner(System.in);
        System.out.print("> ");
        int opcao = entrada.nextInt();

        while(opcao<0 || opcao>9) {
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
