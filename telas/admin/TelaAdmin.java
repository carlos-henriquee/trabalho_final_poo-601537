package telas.admin;



import classes_utilitarias.Leitura;
import classes_utilitarias.RelatorioEstatistica;
import classes_utilitarias.Vacina;
import animal.Animal;
import classes_utilitarias.Adocao;
import classes_utilitarias.Data;
import classes_utilitarias.Evento;
import usuario.*;
import db.AdocoesDB;
import db.AnimaisDB;
import db.EventosDB;
import db.NotificacoesDB;
import db.UsuariosDB;
import db.VacinasDB;
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
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            }
            
            
            

    }
    private static void editarEvento() {
        EventosDB.mostrarEventos();
        int id  = Leitura.lerNumero("\nDigite o id do evento que quer editar: ");
        Evento eventoEncontrado = EventosDB.validarEventoPorId(id);
        if(eventoEncontrado!=null) {
            System.out.println( "1 - Nome do evento\n"+
                                "2 - Data do evento\n"+
                                "0 - Voltar"
            );
            int campo = Leitura.lerNumero("\nDigite o campo que deseja: ");
            switch (campo) {
                case 0:
                    return;
                case 1:
                    String novoNome = Leitura.lerTexto("\nDigite o novo nome do evento: ");
                    eventoEncontrado.setNovoNomeEvento(novoNome);
                    
                    System.out.println("EVENTO EDITADO!");
                break;
                case 2:
                    int novoDia = Leitura.lerNumero("\nDigite o novo dia do evento: ");
                    int novoMes = Leitura.lerNumero("\nDigite o novo mes do evento: ");
                    int novoAno = Leitura.lerNumero("\nDigite o novo ano do evento: ");

                    Data novaData = new Data(novoDia, novoMes, novoAno);
                    eventoEncontrado.setNovaDataEvento(novaData);
                    System.out.println("EVENTO EDITADO!");
                break;
                default:
                    break;
            }
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
                case 3:
                    editarEvento();
                break;
                default:
                    break;
            }
            
        }
    }
    private static void registrarSolicitacao() throws 
        AnimalNaoEncontradoException
    {
        System.out.print("\n==============================================\n");
        System.out.print("                REGISTRAR SOLICITAÇÃO");
        System.out.print("\n==============================================\n");
        AnimaisDB.mostrarAnimais();
        String nomeAnimal = Leitura.lerTexto( "\nDIGITE O NOME DO ANIMAL: ");
        Animal an = AnimaisDB.validarAnimalPorNome(nomeAnimal);
        if(an==null) {
            throw new AnimalNaoEncontradoException("ESSE ANIMAL NAO ESTA CADASTRADO");
        }else{
            if(an.foiAdotado()){
                System.out.println("ESTE ANIMAL JA FOI ADOTADO!");
                return;
            }
        }
        Adocao adocaoJaExiste = AdocoesDB.validarAdocao(nomeAnimal);
        String nomeCandidato = Leitura.lerTexto("Digite o nome do candidato: ");
        if(adocaoJaExiste!=null) {
            adocaoJaExiste.addCadidato(nomeCandidato);
        }else{
            try {
                Adocao solicitacao = new Adocao(an.idAnimal, nomeAnimal);
                solicitacao.addCadidato(nomeCandidato);
                AdocoesDB.registrarSolicitacao(solicitacao);
            } catch (IllegalArgumentException e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } catch (AnimalNaoEncontradoException e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } 
        }
        
        
                            
                    
    }
    private static void aprovarAdocao() {
        AdocoesDB.mostrarAdocoesPendentes();
        
        int id = Leitura.lerNumero("\nDigite o id da adocao que deseja aprovar: ");


        
        Adocao adocaoValidada = AdocoesDB.validarAdocaoPorId(id);

        if(adocaoValidada!=null) {
            String candidatoEscolhido = Leitura.lerTexto("\nDigite o nome do candidato escolhido: ");
            adocaoValidada.setCandidatoEscolhido(candidatoEscolhido);
            adocaoValidada.setAprovada(true);
            adocaoValidada.removerCandidatos();
        }else{
            System.out.println("ADOÇÃO NAO ENCONTRADA!");
            return;
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
                                "4 - Aprovar adoção\n"+
                                "0 - Voltar"
                        );
            System.out.println("Escolha uma opcao: ");
        
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0||opcao>4) {
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
                    try {
                        registrarSolicitacao();
                    } catch (AnimalNaoEncontradoException e) {
                        System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    }
                    
                break;
                case 4:
                    aprovarAdocao();
                break;
                default:
                    break;

        }
    }
    }
    private static void removerUsuario() {
        UsuariosDB.mostrarUsuarios();
        int id = Leitura.lerNumero("\nDigite o id do usuario que deseja remover: ");
        Usuario usuarioValidado = UsuariosDB.validarUsuarioPorId(id);
        if(usuarioValidado!=null) {
            UsuariosDB.removerUsuario(usuarioValidado);
            System.out.println("USUARIO REMOVIDO!");
        }else{
            System.out.println("USUARIO NAO EXISTE!");
        }
    }
    private static void cadastrarVacina() {
        System.out.print("Digite o nome da vacina: ");
        String nomeVacina = Leitura.lerTexto("\n> ");

        System.out.print("Digite a quantidade de novas doses: ");
        int qtdDoses = Leitura.lerNumero("\n> ");


        int diaVencimento = Leitura.lerNumero("\nDigite o dia do vencimento: ");

        int mesVencimento = Leitura.lerNumero("\nDigite o mes do vencimento: ");

        int anoVencimento = Leitura.lerNumero( "\nDigite o ano do vencimento: ");

        Data dataVencimento = new Data(diaVencimento, mesVencimento, anoVencimento);


        Vacina novaVacina = new Vacina(nomeVacina, qtdDoses, dataVencimento);

        VacinasDB.cadastrarVacina(novaVacina);

    }
    private static void editarEstoqueVacina() {
        VacinasDB.mostrarVacinas();

        System.out.print("Digite o nome da vacina que deseja editar: ");
        String nomeVacina = Leitura.lerTexto("\n> ");

        Vacina vacinaValidada = VacinasDB.validarVacinaPorNome(nomeVacina);

        if(vacinaValidada==null){
            System.out.println("VACINA NAO EXISTE!");
        }else{
            System.out.print("Digite a nova quantidade de doses: ");
            int novaQtdDoses = Leitura.lerNumero("\n> ");

            vacinaValidada.setNovaQuantidadeDoses(novaQtdDoses);
        }
    }
    private static void gerenciarVacinas() {
        
        while (true) {
            System.out.print("\n==============================================\n");
            System.out.print("                PAINEL DE ADMINISTRAÇÃO");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Cadastrar nova Vacina\n"+
                                "2 - Editar estoque de uma vacina\n"+
                                "3 - Ver vacinas\n"+
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opcao: ");
            
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0||opcao>3) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero( "\n> ");
            }
            
                switch(opcao) {
                    case 0:
                        return;
                    case 1: 
                        cadastrarVacina();
                    break;

                    case 2:
                        editarEstoqueVacina();
                    break;

                    case 3:
                        VacinasDB.mostrarVacinas();
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
                                "2 - Remover Usuario\n"+
                                "3 - Gerenciar Adoções\n"+
                                "4 - Gerenciar Eventos\n"+
                                "5 - Gerenciar Vacinas\n" +
                                "6 - Relatórios/Estatísticas\n" +
                                "7 - Notificações\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opcao: ");
            
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0||opcao>7) {
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
                        removerUsuario();
                    break;
                    case 3:
                        gerenciarAdocoes();
                    break;
                    case 4:
                        gerenciarEventos();
                    break;
                    case 5:
                        gerenciarVacinas();
                    break;
                    case 6:
                        RelatorioEstatistica.mostrarRelatorio();
                    break;

                    case 7:
                        NotificacoesDB.mostrarNotificacoes();
                    break;

                    default:
                        break;
                }
            }
       
    }
}
