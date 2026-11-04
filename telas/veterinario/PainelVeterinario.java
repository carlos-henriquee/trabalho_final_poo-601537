package telas.veterinario;


import classes_utilitarias.Tratamento;
import classes_utilitarias.Vacinacao;
import classes_utilitarias.Data;
import classes_utilitarias.Consulta;
import classes_utilitarias.Leitura;
import db.AnimaisDB;
import db.ConsultasDB;
import db.TratamentosDB;
import db.VacinacoesDB;
import exceptions.AnimalNaoEncontradoException;
import exceptions.TratamentoNaoEncontradoException;




public class PainelVeterinario {
    private static void gerenciarConsultas() {
        while(true){
            System.out.print("\n==============================================\n");
            System.out.print("                GERENCIAR CONSULTAS");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Ver consultas cadastradas\n" +
                                "2 - Cadastrar consulta\n" +
                                "3 - Concluir consulta\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opção: ");
            int opcao = Leitura.lerNumero("\n> ");

            while(opcao<0 || opcao>10) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero("\n> ");
            }
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    ConsultasDB.mostrarConsultas();
                break;
                case 2:
                    cadastrarConsulta();
                break;
                case 3:
                    concluirConsulta();
                break;
                default:
                    break;
            }
        }
    }
    private static void cadastrarConsulta() {
                if(AnimaisDB.quantidadeAnimaisCadastrados==0) {
                    System.out.println("AINDA NÃO HÁ ANIMAIS CADASTRADOS! UM ANIMAL PRECISA SER CADASTRADO PRIMEIRO!");
                    return;
                }
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR CONSULTA");
                System.out.print("\n====================================================\n");

                    
                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");

                String especie = Leitura.lerTexto("\nDigite a especie do animal: ");

                int diaConsulta = Leitura.lerNumero( "\nDigite o dia do resgate do animal: ");

                int mesConsulta = Leitura.lerNumero( "\nDigite o mes do resgate do animal: ");

                int anConsulta = Leitura.lerNumero( "\nDigite o ano do resgate do animal: ");

                
                try {
                    Data dataResgate = new Data(diaConsulta, mesConsulta, anConsulta);
                    

                    Consulta novaConsulta = new Consulta(nomeAnimal, especie, dataResgate);
                    ConsultasDB.cadastrarConsulta(novaConsulta);
                } catch (IllegalArgumentException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (AnimalNaoEncontradoException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } 
            
    }

    private static void concluirConsulta() {
        ConsultasDB.mostrarConsultas();
        int idConsulta = Leitura.lerNumero( "DIGITE O ID DA CONSULTA: ");
        ConsultasDB.concluirConsulta(idConsulta);

    }

    private static void gerenciarTratamentos() {
        while(true){
            System.out.print("\n==============================================\n");
            System.out.print("                GERENCIAR TRATAMENTOS");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Ver tratamentos cadastrados\n" +
                                "2 - Cadastrar tratamento\n" +
                                "3 - Atualizar tratamento\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opção: ");
            int opcao = Leitura.lerNumero("\n> ");

            while(opcao<0 || opcao>10) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero("\n> ");
            }
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    TratamentosDB.mostrarTratamentos();
                break;
                case 2:
                    cadastrarTratamento();
                break;
                case 3:
                    atualizarTratamento();
                break;
                default:
                    break;
            }
        }
    }
    private static void cadastrarTratamento() {
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR TRATAMENTO");
                System.out.print("\n====================================================\n");

                    
                
                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");


                String especie = Leitura.lerTexto("\nDigite a especie do animal: ");

                String prescricao = Leitura.lerTexto("\nDigite a prescrição: ");

                int diaInicio = Leitura.lerNumero( "\nDigite o dia do inicio do tratamento: ");

                int mesInicio = Leitura.lerNumero( "\nDigite o mes do inicio do tratamento: ");

                int anoInicio = Leitura.lerNumero( "\nDigite o ano do inicio do tratamento: ");



                int diaFim = Leitura.lerNumero( "\nDigite o dia do fim do tratamento: ");

                int mesFim = Leitura.lerNumero( "\nDigite o mes do fim do tratamento: ");

                int anoFim = Leitura.lerNumero( "\nDigite o ano do fim do tratamento: ");
            
                Data inicioTratamento = new Data(diaInicio, mesInicio, anoInicio);
                Data fimTratamento = new Data(diaFim, mesFim, anoFim);   

                Tratamento novoTratamento = new Tratamento(nomeAnimal, especie, inicioTratamento, prescricao, fimTratamento);
                TratamentosDB.cadastrarTratamento(novoTratamento);
    }
    
    private static void atualizarTratamento() {
        while(true) {
            System.out.print("\n==============================================\n");
            System.out.print("                ATUALIZAR TRATAMENTO");
            System.out.print("\n==============================================\n");
            System.out.println("VOCE DESEJA: ");
            System.out.println( "1 - Atualizar tratamento por id\n"+
                                "0 - Voltar"
                            );
            System.out.println("Escolha uma opção: ");
            int opcao = Leitura.lerNumero( "\n> ");

            while(opcao<0 || opcao>9) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero( "\n> ");
            }
            switch (opcao) {
                case 0:
                return;
                
                case 1:
                    int id = Leitura.lerNumero( "Informe o id do tratamento: ");
                    try {
                        TratamentosDB.atualizarTratamento(id);
                    } catch (TratamentoNaoEncontradoException e) {
                        System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    }
                    
                break;
                default:
                    break;
            }
        }
        

    }
    private static void registrarVacinacao() {
                System.out.print("\n====================================================\n");
                System.out.print("                REGISTRAR VACINAÇÃO");
                System.out.print("\n====================================================\n");

                    
                String nomeVacina = Leitura.lerTexto("\nDigite o nome da vacina: ");

                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");
                


                int diaVacinacao = Leitura.lerNumero( "\nDigite o dia do vacinação: ");

                int mesVacinacao = Leitura.lerNumero( "\nDigite o mes do vacinação: ");

                int anoVacinacao = Leitura.lerNumero( "\nDigite o ano do vacinação: ");


                try {
                    Data dataAplicacao = new Data(diaVacinacao, mesVacinacao, anoVacinacao); 
                    Vacinacao vac = new Vacinacao(nomeVacina, nomeAnimal, dataAplicacao);
                    VacinacoesDB.cadastrarVacinacao(vac);
                } catch (IllegalArgumentException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (AnimalNaoEncontradoException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                }
                
    }
    public static void mostrarInterface() {
        while(true){
        System.out.print("\n==============================================\n");
        System.out.print("                ÁREA DO VETERINÁRIO");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Gerenciar consultas\n" +
                            "2 - Gerenciar tratamentos\n" +
                            "3 - Registrar Vacinação\n"+
                            "4 - Emitir Relatório Médico\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opção: ");
        int opcao = Leitura.lerNumero("\n> ");

        while(opcao<0 || opcao>4) {
            System.out.println("Opção inválida! Digite novamente!");
            opcao = Leitura.lerNumero("\n> ");
        }

       
            switch(opcao) {
                case 0:
                    return;
                case 1: 
                    gerenciarConsultas();
                break;
                case 2:
                    gerenciarTratamentos();
                break;
                case 3:
                    registrarVacinacao();
                break;
                default:
                break;
            }
        }
    }
}

