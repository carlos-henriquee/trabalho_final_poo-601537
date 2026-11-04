package db;

import java.util.ArrayList;

import animal.Animal;
import exceptions.AnimalNaoEncontradoException;


public class AnimaisDB {
    private static ArrayList<Animal> animaisCadastrados = new ArrayList<Animal>();
    
    public static void cadastrar(Animal a) 
        throws IllegalArgumentException
    {

        if( a.nomeAnimal==null || 
            a.especie == null || 
            a.raca==null || 
            a.porte == null ||
            a.estadoDeSaude == null || 
            a.dataDeResgate == null 
            

        )
            throw new IllegalArgumentException("CAMPOS NULOS");
        if( a.especie.equals("") || 
            a.raca.equals("") ||
            a.estadoDeSaude.equals("")
        )
            throw new IllegalArgumentException("CAMPOS VAZIOS");

        if(a.idade<0)
            throw new IllegalArgumentException("IDADE INVALIDA!");

        
        animaisCadastrados.add(a);
        System.out.println("ANIMAL CADASTRADO COM SUCESSO!");
        NotificacoesDB.add("NOVO ANIMAL CADASTRADO!");
    }
    public static int getQuantidadeAnimaisCadastrados() {
        return animaisCadastrados.size();
    }
    public static void removerAnimalPorId(int idAnimal) {
        Animal animalValidado = validarAnimalPorId(idAnimal);
        if(animalValidado==null){
            System.out.println("ESSE ANIMAL NAO ESTA CADASTRADO!");
            return;
        }else{
            animaisCadastrados.remove(animalValidado);
        }
    }
    public static Animal validarAnimalPorId(int id) {
        int i = 0;

        while(i<animaisCadastrados.size()) {
            if(animaisCadastrados.get(i).idAnimal==id) {
                return animaisCadastrados.get(i);
            }
            i++;
        }
        return null;
    }
    public static Animal validarAnimalPorNome(String nomeAnimal) {
        int i = 0;

        while(i<animaisCadastrados.size()) {
            if(animaisCadastrados.get(i).nomeAnimal.toLowerCase().trim().equals(nomeAnimal.toLowerCase().trim())) {
                return animaisCadastrados.get(i);
            }
            i++;
        }
        return null;
    }
    public static void mostrarAnimais() {
        System.out.print("\n====================================================\n");
        System.out.print("                ANIMAIS CADASTRADOS");
        System.out.print("\n====================================================\n");
        if(animaisCadastrados.size()==0) {
            System.out.println("TABELA VAZIA!");
        }else{
            for(Animal animal: animaisCadastrados) {
                System.out.println( " - ID: " + animal.idAnimal + 
                                    " | Nome: " + (animal.nomeAnimal.equals("")?"SEM NOME": animal.nomeAnimal) + 
                                    " | Especie: " + animal.especie +
                                    " | Idade(anos): " + animal.idade +
                                    " | Estado de Saude: " + animal.estadoDeSaude +
                                    " | Status de Adoção: " + (animal.adotado?"ADOTADO":"NAO ADOTADO") 
                                );
            }
        }
        
    }
    public static void mostrarAnimaisDisponiveisParaAdocao() {
        System.out.print("\n====================================================\n");
        System.out.print("                ANIMAIS PARA ADOÇÃO");
        System.out.print("\n====================================================\n");
        if(animaisCadastrados.size()==0) {
            System.out.println("TABELA VAZIA!");
            return;
        }else{
            for(Animal animal: animaisCadastrados) {
                if(animal.adotado==false) {
                    System.out.println( " - ID: " + animal.idAnimal + 
                                    " | Nome: " + (animal.nomeAnimal.equals("")?"SEM NOME": animal.nomeAnimal) + 
                                    " | Especie: " + animal.especie +
                                    " | Idade(anos): " + animal.idade +
                                    " | Estado de Saude: " + animal.estadoDeSaude 
                                );
                }
                
            }
        }
        
    }

    public static void mostrarDetalhesPorId(int id) throws AnimalNaoEncontradoException{
        int i = 0;
        boolean encontrou = false;
        while(encontrou==false && i<animaisCadastrados.size()) {
            if(animaisCadastrados.get(i).idAnimal==id) {
                Animal animal = animaisCadastrados.get(i);
                System.out.println( " - ID: " + animal.idAnimal + 
                                    "\n | Nome: " + (animal.nomeAnimal.equals("")?"SEM NOME": animal.nomeAnimal) + 
                                    "\n | Especie: " + animal.especie +
                                    "\n | Raça: " + animal.raca +
                                    "\n | Idade(anos): " + animal.idade +
                                    "\n | Porte: " + animal.getPorte() +
                                    "\n | Estado de Saude: " + animal.estadoDeSaude +
                                    "\n | Data de resgate: " + animal.getDataResgate()+
                                    "\n | Status de Adoção: " + (animal.adotado? "ADOTADO": "NAO ADOTADO") 
                                );
            }
        }
        if(encontrou==false)
            throw new AnimalNaoEncontradoException("ANIMAL NAO ENCONTRADO");
    }
    

}
