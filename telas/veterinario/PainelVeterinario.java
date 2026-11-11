package telas.veterinario;


import classes_utilitarias.Tratamento;
import classes_utilitarias.Vacinacao;
import classes_utilitarias.Data;
import classes_utilitarias.Consulta;
import classes_utilitarias.Leitura;
import classes_utilitarias.RelatorioMedico;
import classes_utilitarias.Vacina;
import db.AnimaisDB;
import db.ConsultasDB;
import db.RelatoriosMedicosDB;
import db.TratamentosDB;
import db.VacinacoesDB;
import db.VacinasDB;
import exceptions.AnimalNaoEncontradoException;
import exceptions.TratamentoNaoEncontradoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import animal.*;



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

            while(opcao<0 || opcao>3) {
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
                if(AnimaisDB.getQuantidadeAnimaisCadastrados()==0) {
                    System.out.println("AINDA NÃO HÁ ANIMAIS CADASTRADOS! UM ANIMAL PRECISA SER CADASTRADO PRIMEIRO!");
                    return;
                }
                System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR CONSULTA");
                System.out.print("\n====================================================\n");

                    
                AnimaisDB.mostrarAnimais();
                String nomeAnimal = Leitura.lerTexto( "\nDIGITE O NOME DO ANIMAL: ");
                Animal an = AnimaisDB.validarAnimalPorNome(nomeAnimal);
                if(an==null) {
                    System.out.println("ESSE ANIMAL NAO ESTA CADASTRADO");
                    return;
                }
                int diaConsulta = Leitura.lerNumero( "\nDigite o dia da consulta: ");

                int mesConsulta = Leitura.lerNumero( "\nDigite o mes da consulta: ");

                int anConsulta = Leitura.lerNumero( "\nDigite o ano da consulta: ");

                
                try {
                    Data dataConsulta = new Data(diaConsulta, mesConsulta, anConsulta);
                    

                    Consulta novaConsulta = new Consulta(an.nomeAnimal, an.especie, dataConsulta);
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

            while(opcao<0 || opcao>3) {
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

                    
                
                AnimaisDB.mostrarAnimais();
                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");
                Animal an = AnimaisDB.validarAnimalPorNome(nomeAnimal);
                if(an==null) {
                    System.out.println("ESSE ANIMAL NAO ESTA CADASTRADO");
                    return;
                }
                
                String prescricao = Leitura.lerTexto("\nDigite a prescrição: ");
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");

                LocalDate dataInicio;
                LocalDate dataFim;
                
                int diaInicio;
                int mesInicio;
                int anoInicio;

                int diaFim;
                int mesFim;
                int anoFim;
                
                while (true) {
                    diaInicio = Leitura.lerNumero("\nDigite o dia do inicio do tratamento: ");
                    mesInicio = Leitura.lerNumero("\nDigite o dia do inicio do tratamento: ");
                    anoInicio = Leitura.lerNumero("\nDigite o dia do inicio do tratamento: ");

                    diaFim = Leitura.lerNumero( "\nDigite o dia do fim do tratamento: ");
                    mesFim = Leitura.lerNumero( "\nDigite o mes do fim do tratamento: ");
                    anoFim = Leitura.lerNumero( "\nDigite o ano do fim do tratamento: ");
            



                    String dataInicioParcial = String.format("%02d/%02d/%04d", diaInicio, mesInicio, anoInicio);
                    String dataFimParcial = String.format("%02d/%02d/%04d", diaFim, mesFim, anoFim);
                    try {
                        dataInicio = LocalDate.parse(dataInicioParcial, formatador);
                        dataFim = LocalDate.parse(dataFimParcial, formatador);
                        if (dataInicio.isAfter(dataFim)) {
                            System.out.println("DATA INVALIDA! A data de inicio nao pode ser posterior a de fim");
                        } else {
                            break;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("DATA INVALIDA! Essa data não existe.");
                    }
                }


                Data inicioTratamento = new Data(diaInicio, mesInicio, anoInicio);
                Data fimTratamento = new Data(diaFim, mesFim, anoFim);   



                Tratamento novoTratamento = new Tratamento(an.nomeAnimal, an.especie, inicioTratamento, prescricao, fimTratamento);
                TratamentosDB.cadastrarTratamento(novoTratamento);
                if(an.emTratamento==false) {
                    an.emTratamento = true;
                }
                
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

            while(opcao<0 || opcao>1) {
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

                Vacina vacinaValidada = VacinasDB.validarVacinaPorNome(nomeVacina);
                if(vacinaValidada==null) {
                    System.out.println("VACINA NAO EXISTE NO BANCO DE DADOS!");
                    return;
                }
                if(vacinaValidada.getQuantidadeDoses()==0) {
                    System.out.println("NAO EXISTEM DOSES DISPONIVEIS!");
                    return;
                }


                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");
                


                int diaVacinacao = Leitura.lerNumero( "\nDigite o dia do vacinação: ");

                int mesVacinacao = Leitura.lerNumero( "\nDigite o mes do vacinação: ");

                int anoVacinacao = Leitura.lerNumero( "\nDigite o ano do vacinação: ");


                try {
                    Data dataAplicacao = new Data(diaVacinacao, mesVacinacao, anoVacinacao); 
                    Vacinacao vac = new Vacinacao(nomeVacina, nomeAnimal, dataAplicacao);
                    VacinacoesDB.cadastrarVacinacao(vac);
                    int novaQuantidadeDoses = vacinaValidada.getQuantidadeDoses() - 1;
                    vacinaValidada.setNovaQuantidadeDoses(novaQuantidadeDoses);

                } catch (IllegalArgumentException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (AnimalNaoEncontradoException e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                }
                
    }
    private static void emitirRelatiorioMedico() {
        AnimaisDB.mostrarAnimais();
        System.out.print("Digite o id do animal que deseja emitir relatorio medico");
        int id = Leitura.lerNumero("\n>");

        Animal animalValidado = AnimaisDB.validarAnimalPorId(id);
        if(animalValidado==null) {
            System.out.println("ANIMAL NAO ENCONTRADO!");
        }else{
            System.out.print("Digite a anamnese: ");
            String anamnese = Leitura.lerTexto("\n> ");
            System.out.print("Digite o peso em Kg do animal: ");
            double pesoAtualKG = Leitura.lerNumeroReal("\n> ");

            RelatorioMedico rm = new RelatorioMedico(anamnese, pesoAtualKG);
            rm.setAnimalRelatorioMedico(animalValidado);
            RelatoriosMedicosDB.registrarRelatorio(rm);
        }


    }
    private static void exibirRelatorioMedico() {
        AnimaisDB.mostrarAnimais();
        System.out.print("Digite o id do animal que deseja ver relatorio medico");
        int id = Leitura.lerNumero("\n>");

        Animal animalValidado = AnimaisDB.validarAnimalPorId(id);
        if(animalValidado==null) {
            System.out.println("ANIMAL NAO ENCONTRADO!");
        }else{
            RelatoriosMedicosDB.exibirRelatorioPorAnimal(animalValidado);
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
                            "4 - Ver vacinações realizadas\n" +
                            "5 - Emitir Relatório Médico\n" +
                            "6 - Exibir Relatório Médico\n" +
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opção: ");
        int opcao = Leitura.lerNumero("\n> ");

        while(opcao<0 || opcao>6) {
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
                case 4:
                    VacinacoesDB.mostrarVacinacoes();
                break;

                case 5:
                    emitirRelatiorioMedico();
                break;

                case 6:
                    exibirRelatorioMedico();
                break;
                default:
                break;
            }
        }
    }
}

