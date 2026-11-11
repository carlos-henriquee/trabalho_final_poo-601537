package telas.admin;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import animal.Animal;
import classes_utilitarias.Data;
import classes_utilitarias.Leitura;
import classes_utilitarias.Porte;
import usuario.*;
import db.AnimaisDB;
import db.UsuariosDB;

public class TelaGestaoAnimais {
    
    private static void cadastrarAnimal() {
        System.out.print("\n====================================================\n");
                System.out.print("                CADASTRAR ANIMAL");
                System.out.print("\n====================================================\n");

                String nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");
                while((nomeAnimal==null || nomeAnimal.equals(""))) {
                    System.out.println("NOME DO ANIMAL NAO INFORMADO!");
                    nomeAnimal = Leitura.lerTexto("\nDigite o nome do animal: ");
                }

                String especie = Leitura.lerTexto("\nDigite a especie do animal: ");

                while((especie==null || especie.equals(""))) {
                    System.out.println("ESPECIE NAO INFORMADA!");
                    especie = Leitura.lerTexto("\nDigite a especie do animal: ");
                }


                String raca = Leitura.lerTexto("\nDigite a raça do animal: ");
                
                
                int idadeCadastro = Leitura.lerNumero("\nDigite a idade(anos) do animal: ");
                
                
                Porte porteCadastro = Leitura.lerPorte("\nPorte do animal(pequeno/medio/grande): ");
                

                String estadoDeSaude = Leitura.lerTexto("\nDigite o estado de saude do animal: ");

                while(estadoDeSaude==null || estadoDeSaude.equals("")) {
                    System.out.println("ESTADO DE SAUDE NAO INFORMADO!");
                    estadoDeSaude = Leitura.lerTexto("\nDigite o estado de saude do animal: ");
                }


                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");

                LocalDate data;
                
                int diaResgate;
                int mesResgate;
                int anoResgate;
                while (true) {
                    diaResgate = Leitura.lerNumero("\nDigite o dia do resgate do animal: ");
                    mesResgate = Leitura.lerNumero("\nDigite o mes do resgate do animal: ");
                    anoResgate = Leitura.lerNumero("\nDigite o ano do resgate do animal: ");

                    String dataParcial = String.format("%02d/%02d/%04d", diaResgate, mesResgate, anoResgate);

                    try {
                        data = LocalDate.parse(dataParcial, formatador);

                        if (data.isAfter(LocalDate.now())) {
                            System.out.println("DATA INVALIDA! A data não pode ser posterior a hoje.");
                        } else {
                            break;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("DATA INVALIDA! Essa data não existe.");
                    }
                }
                
                
            
                Data dataResgate = new Data(diaResgate, mesResgate, anoResgate);
                    
                System.out.println("\nDigite o nome do voluntario responsavel(Opcional):");
                
                String nomeVoluntario = Leitura.lerTexto( "> ");
                if(nomeVoluntario.length()>0 && UsuariosDB.validarVoluntarioPorNome(nomeVoluntario)==null){
                    System.out.println("AINDA NAO HA VOLUNTARIOS! O ANIMAL SERA CADASTRADO SEM UM VOLUNTARIO RESPONSAVEL!");
                    nomeVoluntario = "";
                }
                    
                

                Animal novoAnimal = new Animal(nomeAnimal, especie, raca, idadeCadastro, porteCadastro, estadoDeSaude, dataResgate, false, nomeVoluntario);
                AnimaisDB.cadastrar(novoAnimal);
            
    }
    private static void editarAnimal() {
        System.out.print("\n==============================================\n");
        System.out.print("                EDITAR ANIMAL");
        System.out.print("\n==============================================\n");
        AnimaisDB.mostrarAnimais();

        int id = Leitura.lerNumero("\n Digite o id do animal que deseja editar: ");

        
        AnimaisDB.mostrarDetalhesAnimalId(id);
        
        System.out.println( "1 - Editar nome\n"+
                            "2 - Editar idade\n"+
                            "3 - Editar porte\n" +
                            "4 - Editar estaado de saude\n" +
                            "0 - Nenhum/Voltar"
                        );
        System.out.print("Digite qual campo deseja editar");
        int campo = Leitura.lerNumero("\n> ");
        Animal an = AnimaisDB.validarAnimalPorId(id);
        switch (campo) {
            case 0:
                return;
            case 1:
                
                System.out.println("Nome atual: " + an.nomeAnimal);
                String novoNome = Leitura.lerTexto("\nDigite o novo nome: ");
                while(novoNome==null||novoNome.equals("")) {
                    System.out.println("NOVO NOME NAO INFORMADO!");
                    novoNome = Leitura.lerTexto("\nDigite o novo nome: ");
                }
                an.setNovoNome(novoNome);
            break;
            case 2:
                System.out.println("Idade atual: " + an.idade);
                int novaIdade = Leitura.lerNumero("\nDigite a nova idade: ");
                while(novaIdade<=0) {
                    System.out.println("NOVO IDADE INVALIDA!");
                    novoNome = Leitura.lerTexto("\nDigite a nova idade: ");
                }
                an.setNovaIdade(novaIdade);
            break;
            case 3:
                System.out.println("Porte atual: " + an.getPorte());
                Porte novoPorte = Leitura.lerPorte("\nDigite o novo porte: ");

                an.setNovoPorte(novoPorte);
            break;
            case 4:
                System.out.println("Estado de saúde atual: " + an.estadoDeSaude);
                String novoEstado = Leitura.lerTexto("\nDigite o novo estado de saúde: ");

                while(novoEstado==null||novoEstado.equals("")) {
                    System.out.println("NOVO ESTADO DE SAUDE NAO INFORMADO!");
                    novoEstado = Leitura.lerTexto("\nDigite o novo estado de saúde: ");
                }

                an.setNovoEstadoDeSaude(novoEstado);
            break;
        
            default:
                break;
        }
    }
    private static void atribuirVoluntario() {
        AnimaisDB.mostrarAnimais();
        System.out.print("Digite o id do animal que deseja atribuir o voluntario: ");
        int idAnimal = Leitura.lerNumero("\n> ");

        Animal animalValidado = AnimaisDB.validarAnimalPorId(idAnimal);

        if(animalValidado==null)
            return;

        System.out.println("Animal: " + animalValidado.nomeAnimal);
        
        UsuariosDB.mostrarVoluntarios();

        String nomeVoluntario = Leitura.lerTexto("\nDigite o nome do voluntario: ");

        Voluntario  voluntarioResponsavel = (Voluntario)UsuariosDB.validarVoluntarioPorNome(nomeVoluntario);
        if(voluntarioResponsavel==null) {
            System.out.println("ESSE VOLUNTARIO NAO EXISTE!");
            return;
        }
        voluntarioResponsavel.adicionarAnimal(animalValidado);
        animalValidado.nomeVoluntarioResponsavel = nomeVoluntario;

    }
    private static void removerVoluntarioAtribuido() {
        AnimaisDB.mostrarAnimais();
        System.out.print("Digite o id do animal que remover o voluntario: ");
        int idAnimal = Leitura.lerNumero("\n> ");

        Animal animalValidado = AnimaisDB.validarAnimalPorId(idAnimal);

        if(animalValidado==null)
            return;
        if(animalValidado.nomeVoluntarioResponsavel==null || animalValidado.nomeVoluntarioResponsavel.equals("")){
            System.out.println("NAO HA VOLUNTARIOS RESPONSAVEIS POR ESSE ANIMAL!");
            return;
        }

        System.out.println("Animal: " + animalValidado.nomeAnimal);
        
        Voluntario vol = (Voluntario)UsuariosDB.validarVoluntarioPorNome(animalValidado.nomeVoluntarioResponsavel);

        vol.removerAnimal(animalValidado);
        animalValidado.nomeVoluntarioResponsavel = "";



        System.out.println("Voluntario Removido!");

    }
    private static void removerAnimal() {
        AnimaisDB.mostrarAnimais();
        System.out.print("Digite o id do animal que deseja remover: ");
        int id = Leitura.lerNumero("\n> ");
        Animal an = AnimaisDB.validarAnimalPorId(id);
        if(an.foiAdotado()==true) {
            System.out.println("UM ANIMAL ADOTADO NAO PODE SER REMOVIDO DO HISTORICO!");
            return;
        }
        AnimaisDB.removerAnimalPorId(id);

    }
    public static void mostrarInterface() {
        while(true) {
        System.out.print("\n==============================================\n");
        System.out.print("                GESTAO DE ANIMAIS");
        System.out.print("\n==============================================\n");
        System.out.println( "1 - Cadastrar animal\n"+
                            "2 - Ver animais cadastrados\n"+
                            "3 - Ver detalhes de um animal\n" +
                            "4 - Editar dados de um animal\n" +
                            "5 - Atribuir um voluntario\n" +
                            "6 - Remover um voluntário atribuído\n" +
                            "7 - Remover Animal\n"+
                            "0 - Sair"
                        );
        System.out.println("Escolha uma opcao: ");
        int opcao = Leitura.lerNumero("\n>");

        while(opcao<0||opcao>7) {
            System.out.println("Opção inválida! Digite novamente!");
            opcao = Leitura.lerNumero(">");
            
        }
       
            switch(opcao) {

                case 0:
                return;

                case 1: 
                    
                    cadastrarAnimal();
                
                break;            

                case 2:
                    AnimaisDB.mostrarAnimais();
                break;
                case 3:
                    AnimaisDB.mostrarAnimais();
                    int id = Leitura.lerNumero("\nDigite o id do animal: ");
                    
                    AnimaisDB.mostrarDetalhesAnimalId(id);
                    
                    break;
                case 4:
                    editarAnimal();
                break;
                case 5:
                    atribuirVoluntario();
                break;
                case 6:
                    removerVoluntarioAtribuido();
                break;

                case 7:
                    removerAnimal();
                break;
                default:
                break;
            }
        }

        
    }
}

