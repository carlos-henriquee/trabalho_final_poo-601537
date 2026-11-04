package classes_utilitarias;

import animal.Animal;
import db.AnimaisDB;
import exceptions.AnimalNaoEncontradoException;


public class Adocao {
    private int idAdocao;
    private String nomeAnimal;
    private boolean aprovada;
    private String nomeTutorCandidato;
    private static int idAdocaoGlobal = 0;
    

    public Adocao(int idAnimal, String nomeAnimal, String nomeTutorCandidato) 
        throws  IllegalArgumentException,
                AnimalNaoEncontradoException
        {
        
        if(idAnimal<=0)
            throw new IllegalArgumentException("ID DO ANIMAL NAO INFORMADO OU INVALIDO");
        if(nomeTutorCandidato==null || nomeTutorCandidato.equals(""))
            throw new IllegalArgumentException("NOME DO TUTOR NAO INFORMADO"); 
        if(nomeAnimal==null || nomeAnimal.equals(""))
            throw new IllegalArgumentException("NOME DO TUTOR NAO INFORMADO"); 
        
        
        if(AnimaisDB.validarAnimalPorId(idAnimal)==null) {
            throw new AnimalNaoEncontradoException("ANIMAL COM ESSE ID NAO EXISTE!");
        }
        idAdocaoGlobal++;

        this.nomeTutorCandidato = nomeTutorCandidato;
        this.aprovada = false;
        this.idAdocao = idAdocaoGlobal;
        this.nomeAnimal = nomeAnimal;
    }
    public int getIdAdocao() {
        return this.idAdocao;
    }
    public String getCandidato() {
        return this.nomeTutorCandidato;
    }
    public int getIdAnimalAdocao() {
        Animal an = AnimaisDB.validarAnimalPorNome(this.nomeAnimal);
        return an.idAnimal;
    }
    public boolean foiAprovada() {
        return this.aprovada;
    }

    public void getAnimal() {
        Animal an =  AnimaisDB.validarAnimalPorNome(nomeAnimal);
        try {
            AnimaisDB.mostrarDetalhesPorId(an.idAnimal);
        } catch (AnimalNaoEncontradoException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        }
        
    }
    public void setAprovada(boolean status) {
        this.aprovada = status;
    }
    
}
