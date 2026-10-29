package telas.admin;

import java.util.Scanner;

import classes_utilitarias.Leitura;
import classes_utilitarias.Data;
import classes_utilitarias.Evento;
import telas.Menu;
import db.EventosDB;
import db.UsuariosDB;
public class TelaAdmin {
    static Scanner entrada = new Scanner(System.in);
    private static void cadastrarEvento() {
            System.out.print("\n==============================================\n");
            System.out.print("                CADASTRAR EVENTO");
            System.out.print("\n==============================================\n");
            System.out.println("Digite o nome do evento: ");
            System.out.print("> ");
            String nomeEvento = entrada.nextLine();


            int diaEvento = Leitura.lerNumero(entrada, "\nDigite o dia do evento: ");

            int mesEvento = Leitura.lerNumero(entrada, "\nDigite o mes do evento: ");

            int anoEvento = Leitura.lerNumero(entrada, "\nDigite o ano do evento: ");

            Data dataEvento = new Data(diaEvento, mesEvento, anoEvento);

            try {
                Evento novoEvento = new Evento(nomeEvento, dataEvento);
                EventosDB.cadastrarEvento(novoEvento);
            } catch (IllegalArgumentException e) {
                System.out.println("HOUVE UM ERRO COCO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("HOUVE UM ERRO COCO: " + e.getMessage());
            }
            
            
            

    }
    private static void gerenciarEventos() {
        while (true) {
            System.out.print("\n==============================================\n");
            System.out.print("                GERENCIAR EVENTOS");
            System.out.print("\n==============================================\n");
            System.out.println("O QUE DESEJA FAZER?");
            System.out.println(
                        "1 - Ver eventos cadastrados\n"+
                        "2 - Cadastrar evento\n" +
                        "3 - Editar evento\n" +
                        "0 - Voltar"
            );
            int opcao = Leitura.lerNumero(entrada, "\n> ");
            while (opcao<0 || opcao>3) {
                System.out.println("OPÇÃO INVALIDA! DIGITE NOVAMENTE!");
                opcao = Leitura.lerNumero(entrada, "\n> ");
            }
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    EventosDB.mostrarEventos();
                break;
                case 2:
                    cadastrarEvento();
                break;
                default:
                    break;
            }
            
        }
    }
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
        
        int opcao = Leitura.lerNumero(entrada, "\n> ");

        while(opcao<0||opcao>7) {
            System.out.println("Opção inválida! Digite novamente!");
            opcao = Leitura.lerNumero(entrada, "\n> ");
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
                case 3:
                    
                break;
                case 4:
                    gerenciarEventos();
                break;
                default:
                    break;
            }
        
        Menu.mostrarInterface();
        entrada.close();
    }
}
