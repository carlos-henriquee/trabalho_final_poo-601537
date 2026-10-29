package telas.veterinario;
import java.util.Scanner;

import animal.Animal;
import classes_utilitarias.Porte;
import classes_utilitarias.Tratamento;
import classes_utilitarias.Data;
import classes_utilitarias.Consulta;
import classes_utilitarias.Leitura;
import db.AnimaisDB;
import db.ConsultasDB;
import db.NotificacoesDB;
import db.TratamentosDB;
import exceptions.TratamentoNaoEncontradoException;
import telas.admin.TelaGestaoAnimais;
import telas.voluntario.CadastroVoluntario;



public class PainelVeterinario {
    static Scanner entrada = new Scanner(System.in);
    
    private static void cadastrarAnimal() {
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR ANIMAL");
                System.out.print("\n====================================================\n");

                    
                System.out.print("\nDigite o nome do animal: ");
                String nomeAnimal = entrada.nextLine();

                System.out.print("\nDigite a especie do animal: ");
                String especie = entrada.nextLine();

                System.out.print("\nDigite a raça do animal: ");
                String raca = entrada.nextLine();
                
                
                int idadeCadastro = Leitura.lerNumero(entrada, "\nDigite a idade(anos) do animal: ");
                
                

                System.out.print("\nDigite o porte do animal: ");
                String porteCadastro = entrada.nextLine();

                Porte porte = new Porte(porteCadastro);

                System.out.print("\nDigite o estado de saude do animal: ");
                String estadoDeSaude = entrada.nextLine();

                int diaResgate = Leitura.lerNumero(entrada, "\nDigite o dia do resgate do animal: ");

                int mesResgate = Leitura.lerNumero(entrada, "\nDigite o mes do resgate do animal: ");

                int anoResgate = Leitura.lerNumero(entrada, "\nDigite o ano do resgate do animal: ");

                
            
                Data dataResgate = new Data(diaResgate, mesResgate, anoResgate);
                    
                System.out.print("\nDigite o status de adoção do animal: ");
                String statusDeAdocao = entrada.nextLine();
                int idVoluntario = Leitura.lerNumero(entrada, "Digite o id do voluntario responsavel: ");

                Animal novoAnimal = new Animal(nomeAnimal, especie, raca, idadeCadastro, porte, estadoDeSaude, dataResgate, statusDeAdocao, idVoluntario);
                AnimaisDB.cadastrar(novoAnimal);

                TelaGestaoAnimais.mostrarInterface();    
            
    }
    private static void cadastrarConsulta() {
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR CONSULTA");
                System.out.print("\n====================================================\n");

                    
                System.out.print("\nDigite o nome do animal: ");
                String nomeAnimal = entrada.nextLine();

                System.out.print("\nDigite a especie do animal: ");
                String especie = entrada.nextLine();

                int diaConsulta = Leitura.lerNumero(entrada, "\nDigite o dia do resgate do animal: ");

                int mesConsulta = Leitura.lerNumero(entrada, "\nDigite o mes do resgate do animal: ");

                int anConsulta = Leitura.lerNumero(entrada, "\nDigite o ano do resgate do animal: ");

                
            
                Data dataResgate = new Data(diaConsulta, mesConsulta, anConsulta);
                    

                Consulta novaConsulta = new Consulta(nomeAnimal, especie, dataResgate);
                ConsultasDB.cadastrarConsulta(novaConsulta);

                TelaGestaoAnimais.mostrarInterface();    
            
    }
    private static void cadastrarTratamento() {
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR TRATAMENTO");
                System.out.print("\n====================================================\n");

                    
                System.out.print("\nDigite o nome do animal: ");
                String nomeAnimal = entrada.nextLine();

                System.out.print("\nDigite a especie do animal: ");
                String especie = entrada.nextLine();

                System.out.print("\nDigite a prescrição: ");
                String prescricao = entrada.nextLine();

                int diaInicio = Leitura.lerNumero(entrada, "\nDigite o dia do inicio do tratamento: ");

                int mesInicio = Leitura.lerNumero(entrada, "\nDigite o mes do inicio do tratamento: ");

                int anoInicio = Leitura.lerNumero(entrada, "\nDigite o ano do inicio do tratamento: ");



                int diaFim = Leitura.lerNumero(entrada, "\nDigite o dia do fim do tratamento: ");

                int mesFim = Leitura.lerNumero(entrada, "\nDigite o mes do fim do tratamento: ");

                int anoFim = Leitura.lerNumero(entrada, "\nDigite o ano do fim do tratamento: ");
            
                Data inicioTratamento = new Data(diaInicio, mesInicio, anoInicio);
                Data fimTratamento = new Data(diaFim, mesFim, anoFim);   

                Tratamento novoTratamento = new Tratamento(nomeAnimal, especie, inicioTratamento, prescricao, fimTratamento);
                TratamentosDB.cadastrarTratamento(novoTratamento);
                PainelVeterinario.mostrarInterface();
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
            int opcao = Leitura.lerNumero(entrada, "\n> ");

            while(opcao<0 || opcao>9) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero(entrada, "\n> ");
            }
            switch (opcao) {
                case 0:
                return;
                
                case 1:
                    int id = Leitura.lerNumero(entrada, "Informe o id do tratamento: ");
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
    public static void mostrarInterface() {
        while(true){
        System.out.print("\n==============================================\n");
        System.out.print("                ÁREA DO VETERINÁRIO");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Ver animais cadastrados\n"+
                            "2 - Ver consultas cadastradas\n" +
                            "3 - Ver tratamentos cadastrados\n"+
                            "4 - Cadastrar animal\n" +
                            "5 - Cadastrar consulta\n" +
                            "6 - Cadastrar tratamento\n" +
                            "7 - Atualizar Tratamento\n"+
                            "8 - Registrar Vacinação\n"+
                            "9 - Emitir Relatório Médico\n" +
                            "10 - Notificações\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opção: ");
        int opcao = Leitura.lerNumero(entrada,"\n> ");

        while(opcao<0 || opcao>10) {
            System.out.println("Opção inválida! Digite novamente!");
            opcao = Leitura.lerNumero(entrada,"\n> ");
        }

       
            switch(opcao) {
                case 0:
                    return;
                case 1: 
                    CadastroVoluntario.mostrarInterface();
                break;
                case 2:
                    CadastroVoluntario.mostrarInterface();
                break;
                case 3:
                    TratamentosDB.mostrarTratamentos();
                break;
                case 4:
                    cadastrarAnimal();
                break;
                case 5:
                    cadastrarConsulta();
                break;
                case 6:
                    cadastrarTratamento();
                break;
                case 7:
                    atualizarTratamento();
                break;
                case 8:

                break;

                case 9:
                break;

                case 10:
                    NotificacoesDB.mostrarNotificacoes();
                break;
                default:
                break;
            }
        }
    }
}

