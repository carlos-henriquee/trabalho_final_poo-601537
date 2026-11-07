package classes_utilitarias;

import java.util.ArrayList;
import animal.Animal;
import db.AnimaisDB;
import db.NotificacoesDB;
import exceptions.AnimalNaoEncontradoException;


public class Adocao {
    private int idAdocao;
    private String nomeAnimal;
    private boolean aprovada;
    private String candidatoEscolhido;
    private ArrayList<String> candidatos = new ArrayList<String>();
    private static int idAdocaoGlobal = 0;
    

    public Adocao(int idAnimal, String nomeAnimal) 
        throws  IllegalArgumentException,
                AnimalNaoEncontradoException
        {
        
        if(idAnimal<=0)
            throw new IllegalArgumentException("ID DO ANIMAL NAO INFORMADO OU INVALIDO");
        if(nomeAnimal==null || nomeAnimal.equals(""))
            throw new IllegalArgumentException("NOME DO TUTOR NAO INFORMADO"); 
        
        
        if(AnimaisDB.validarAnimalPorId(idAnimal)==null) {
            throw new AnimalNaoEncontradoException("ANIMAL COM ESSE ID NAO EXISTE!");
        }
        idAdocaoGlobal++;

        
        this.aprovada = false;
        this.idAdocao = idAdocaoGlobal;
        this.nomeAnimal = nomeAnimal;
    }
    public int getIdAdocao() {
        return this.idAdocao;
    }
    public void addCadidato(String nomeCandidato) {
        if(nomeCandidato==null || nomeCandidato.equals("")) {
            System.out.println("NOME NULO OU VAZIO!");
            return;
        }
        candidatos.add(nomeCandidato);
    }
    public void getCandidatos() {
        if(candidatos.size()==0){
            System.out.println("SEM CANDIDATOS!");
            return;
        }
        System.out.println("CANDIDATOS");
        int id = 1;
        for(String candidato : candidatos) {
            System.out.println(id + " - " + candidato);
            id++;
        }
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
        
        if(an==null) {
            System.out.println("ANIMAL NAO ENCONTRADO!");
            return;
        }

        AnimaisDB.mostrarDetalhesAnimalId(idAdocao);
        
        
    }
    public void setAprovada(boolean status) {
        this.aprovada = status;
        NotificacoesDB.add("NOVA ADOÇÃO APROVADA!");
    }
    public String getCandidatoEscolhido() {
        return this.candidatoEscolhido;
    }
    public void setCandidatoEscolhido(String candidato) {
        this.candidatoEscolhido = candidato;
    }
    public void removerCandidatos() {
        this.candidatos.clear();
    }
}
