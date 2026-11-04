package telas.admin;



import classes_utilitarias.Leitura;
import classes_utilitarias.RelatorioEstatistica;
import animal.Animal;
import classes_utilitarias.Adocao;
import classes_utilitarias.Data;
import classes_utilitarias.Evento;
import db.AdocoesDB;
import db.AnimaisDB;
import db.EventosDB;
import db.NotificacoesDB;
import db.UsuariosDB;
import exceptions.AnimalNaoEncontradoException;
public class TelaAdmin {
    private static void cadastrarEvento() {
            System.out.print("\n==============================================\n");
            System.out.print("                CADASTRAR EVENTO");
            System.out.print("\n==============================================\n");
            System.out.println("Digite o nome do evento: ");
            System.out.print("> ");
            String nomeEvento = Leitura.lerTexto("Digite o nome do evento: ");


            int diaEvento = Leitura.lerNumero("\nDigite o dia do evento: ");

            int mesEvento = Leitura.lerNumero("\nDigite o mes do evento: ");

            int anoEvento = Leitura.lerNumero( "\nDigite o ano do evento: ");

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
            int opcao = Leitura.lerNumero( "\n> ");
            while (opcao<0 || opcao>3) {
                System.out.println("OPÇÃO INVALIDA! DIGITE NOVAMENTE!");
                opcao = Leitura.lerNumero( "\n> ");
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
    private static void registrarSolicitacao() {
        System.out.print("\n==============================================\n");
        System.out.print("                REGISTRAR SOLICITAÇÃO");
        System.out.print("\n==============================================\n");

        String nomeAnimal = Leitura.lerTexto( "DIGITE O NOME DO ANIMAL: ");
        Animal an = AnimaisDB.validarAnimalPorNome(nomeAnimal);
                if(an==null) {
                    System.out.println("ESSE ANIMAL NAO ESTA CADASTRADO");
                    return;
                }else{
                    if(an.foiAdotado()){
                        System.out.println("ESTE ANIMAL JA FOI ADOTADO!");
                        return;
                    }
                }
        String nomeCandidato = Leitura.lerTexto("Digite o nome do candidato: ");
        try {
            Adocao solicitacao = new Adocao(an.idAnimal, nomeAnimal, nomeCandidato);    
            AdocoesDB.registrarSolicitacao(solicitacao);
        } catch (IllegalArgumentException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch (AnimalNaoEncontradoException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        }                     
                    
    }
    private static void gerenciarAdocoes() {
        while(true) {
            System.out.print("\n==============================================\n");
            System.out.print("                GERENCIAR ADOÇÕES");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Ver adoções aprovadas\n" +
                                "2 - Ver adoções pendentes\n" +
                                "3 - Registrar nova solicitação de adoção\n" +
                                "0 - Voltar"
                        );
            System.out.println("Escolha uma opcao: ");
        
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0||opcao>7) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero( "\n> ");
            }
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    AdocoesDB.mostrarAdocoesAprovadas();
                break;

                case 2:
                    AdocoesDB.mostrarAdocoesPendentes();
                break;

                case 3:
                    registrarSolicitacao();
                break;
                default:
                    break;

        }
    }
    }
    public static void mostrarInterface() {
        while(true) {
            System.out.print("\n==============================================\n");
            System.out.print("                PAINEL DE ADMINISTRAÇÃO");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Gerenciar Animais\n"+
                                "2 - Gerenciar Usuarios\n"+
                                "3 - Gerenciar Adoções\n"+
                                "4 - Gerenciar Eventos\n"+
                                "5 - Relatórios/Estatísticas\n" +
                                "6 - Notificações\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opcao: ");
            
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0||opcao>6) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero( "\n> ");
            }
            
                switch(opcao) {
                    case 0:
                        return;
                    case 1: 
                        TelaGestaoAnimais.mostrarInterface();
                    break;

                    case 2:
                        UsuariosDB.mostrarUsuarios();
                    break;
                    case 3:
                        gerenciarAdocoes();
                    break;
                    case 4:
                        gerenciarEventos();
                    break;
                    
                    case 5:
                        RelatorioEstatistica.mostrarRelatorio();
                    break;

                    case 6:
                        NotificacoesDB.mostrarNotificacoes();
                    break;

                    default:
                        break;
                }
            }
       
    }
}
