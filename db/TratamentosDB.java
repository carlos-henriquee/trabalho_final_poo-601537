package db;

import java.util.ArrayList;
import java.util.Scanner;


import classes_utilitarias.Tratamento;
import classes_utilitarias.Leitura;
import classes_utilitarias.Data;


import exceptions.TratamentoNaoEncontradoException;


public class TratamentosDB {
    public static ArrayList<Tratamento> tratamentos = new ArrayList<Tratamento>();

    public static void cadastrarTratamento(Tratamento c) {
        if(c==null) throw new IllegalArgumentException("TRATAMENTO INVALIDO!");
        tratamentos.add(c);
        NotificacoesDB.add("NOVO TRATAMENTO CADASTRADO!");
    }
    public static void mostrarTratamentos() {
        for( Tratamento tratamento : tratamentos) {
            System.out.println( "- ID: " + tratamento.getIdTratamento() +
                                " | " + tratamento.getAnimalTratamento() +
                                " | Prescricao: " + tratamento.getPrescricao()+
                                " | Inicio: " + tratamento.getInicioTratamento()+
                                " | Fim: " + tratamento.getFimTratamento()
                            );
        }
    }
    public static void atualizarTratamento(int id) 
        throws TratamentoNaoEncontradoException
    {
        boolean encontrou = false;
        int i = 0;
        while(encontrou==false && i<tratamentos.size()) {
            if(tratamentos.get(i).getIdTratamento()==id) {
                encontrou = true;
            }
            i++;
        }
        if(encontrou==false) {
            throw new TratamentoNaoEncontradoException("TRATAMENTO COM ID " + id +"NAO ENCONTRADO");
        }else{
            Tratamento tratamento = tratamentos.get(i);
            System.out.println( "- ID: " + tratamento.getIdTratamento() +
                                " | " + tratamento.getAnimalTratamento() +
                                " | Prescricao: " + tratamento.getPrescricao()+
                                " | Inicio: " + tratamento.getInicioTratamento()+
                                " | Fim: " + tratamento.getFimTratamento()
                            );
            Scanner input = new Scanner(System.in);
            while(true) {
                System.out.println("O QUE DESEJA EDITAR?");
                System.out.println( "1 - Nome do animal\n"+
                                    "2 - Especie do animal\n" +
                                    "3 - Inicio do tratamento\n"+
                                    "4 - Fim do tratamento\n" +
                                    "5 - Prescricao\n" +
                                    "0 - Sair"
                        );
                System.out.println("Escolha uma opção: ");
                int opcao = Leitura.lerNumero(input, "\n> ");

                while(opcao<0 || opcao>10) {
                    System.out.println("Opção inválida! Digite novamente!");
                    opcao = Leitura.lerNumero(input, "\n> ");
                }

            
                switch(opcao) {
                    case 0:
                    return;
                    case 1: 
                        System.out.print("Digite o novo nome: ");
                        String novoNome = input.nextLine();
                    
                        tratamento.setNomeAnimal(novoNome);

                    break;
                    case 2:
                        System.out.print("Digite a nova especie: ");
                        String novaEspecie = input.nextLine();
                    
                        tratamento.setNomeAnimal(novaEspecie);
                    break;
                    case 3:
                        System.out.println("//////NOVO DATA DE INICIO//////");
                        int novoDiaInicio = Leitura.lerNumero(input, "Digite o novo dia: ");
                        int novoMesInicio = Leitura.lerNumero(input, "Digite o novo mes: ");
                        int novoAnoInicio = Leitura.lerNumero(input, "Digite o novo ano: ");

                        Data novoInicio = new Data(novoDiaInicio, novoMesInicio, novoAnoInicio);
                        tratamento.setDataInicio(novoInicio);
                    break;
                    case 4:
                        System.out.println("//////NOVO DATA DE FIM//////");
                        int novoDiaFim = Leitura.lerNumero(input, "Digite o novo dia: ");
                        int novoMesFim = Leitura.lerNumero(input, "Digite o novo mes: ");
                        int novoAnoFim = Leitura.lerNumero(input, "Digite o novo ano: ");

                        Data novoFim = new Data(novoDiaFim, novoMesFim, novoAnoFim);
                        tratamento.setDataInicio(novoFim);

                    break;
                    case 5:
                        System.out.println("//////NOVA PRESCRICAO//////");
                        System.out.println("DIGITE A NOVA PRESCRICAO: ");
                        System.out.print("> ");
                        String novaPrescricao = input.nextLine();

                        tratamento.setPrescricao(novaPrescricao);

                    break;
                }
            

            }
            
            
        }
    }

}
