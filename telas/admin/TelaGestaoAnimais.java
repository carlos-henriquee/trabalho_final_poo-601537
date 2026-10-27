package telas.admin;

import java.util.Scanner;

import animal.Animal;
import classes_utilitarias.Data;
import classes_utilitarias.Porte;
import db.AnimaisDB;
import exceptions.AnimalNaoEncontradoException;
import telas.Menu;

public class TelaGestaoAnimais {
     
    static Scanner entrada = new Scanner(System.in);
    private static int lerNumero(String msg) {
        while(true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch(NumberFormatException e){
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            }
        }
    }
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
                
                
                int idadeCadastro = lerNumero("\nDigite a idade(anos) do animal: ");
                
                

                System.out.print("\nDigite o porte do animal: ");
                String porteCadastro = entrada.nextLine();

                Porte porte = new Porte(porteCadastro);

                System.out.print("\nDigite o estado de saude do animal: ");
                String estadoDeSaude = entrada.nextLine();

                int diaResgate = lerNumero("\nnDigite o dia do resgate do animal: ");

                int mesResgate = lerNumero("\nDigite o mes do resgate do animal: ");

                int anoResgate = lerNumero("\nDigite o ano do resgate do animal: ");

                
            
                Data dataResgate = new Data(diaResgate, mesResgate, anoResgate);
                    
                System.out.print("\nDigite o status de adoção do animal: ");
                String statusDeAdocao = entrada.nextLine();

                Animal novoAnimal = new Animal(nomeAnimal, especie, raca, idadeCadastro, porte, estadoDeSaude, dataResgate, statusDeAdocao);
                AnimaisDB.cadastrar(novoAnimal);

                TelaGestaoAnimais.mostrarInterface();    
            
    }
    
    public static void mostrarInterface() {
        while(true) {
        System.out.print("\n==============================================\n");
        System.out.print("                GESTAO DE ANIMAIS");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Cadastrar animal\n"+
                            "2 - Ver animais cadastrados\n"+
                            "3 - Ver detalhes de um animal\n" +
                            "4 - Remover Animal\n"+
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opcao: ");
        int opcao = lerNumero("\n>");

        while(opcao<0||opcao>4) {
            System.out.println("Opção inválida! Digite novamente!");
            opcao = lerNumero(">");
            
        }
       
            switch(opcao) {

                case 0:
                return;

                case 1: 
                    
                    cadastrarAnimal();
                
                break;            

                case 2:
                    AnimaisDB.mostrarAnimais();
                    TelaGestaoAnimais.mostrarInterface();
                break;
                case 3:
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("Digite o id do animal: ");
                    String idString = input2.nextLine();
                    int id = Integer.parseInt(idString);
                    try {
                        AnimaisDB.mostrarDetalhesPorId(id);
                    } catch (AnimalNaoEncontradoException e) {
                        System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    } catch (Exception e) {
                    System.out.println("HOUVE UM ERRO: " + e.getMessage());
                    }finally{
                        input2.close();
                        TelaGestaoAnimais.mostrarInterface();
                    }
                case 4:
                    System.out.println("REMOVER ANIMAL");
                    
                default:
                    TelaGestaoAnimais.mostrarInterface();
                break;
            }
        
            TelaGestaoAnimais.mostrarInterface();
        }

        
    }
}

