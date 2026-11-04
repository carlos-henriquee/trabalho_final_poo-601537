package db;

import java.util.ArrayList;

import animal.Animal;
import classes_utilitarias.Adocao;

public class AdocoesDB {
    static ArrayList<Adocao> adocoes = new ArrayList<Adocao>();
    public static void registrarSolicitacao(Adocao a) 
        throws IllegalArgumentException
    {
        if(a==null) 
            throw new IllegalArgumentException("CONSULTA INVALIDA");
        adocoes.add(a);
    }
    public static int getQuantidadeAdocoesAprovadas() {
        return adocoes.size();
    }
    public static void mostrarAdocoesPendentes() {
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==false){
                System.out.println( "- ID: " + adocao.getIdAdocao());
                System.out.println("NOME DO TUTOR: " + adocao.getCandidato());
                adocao.getAnimal();
            }
            
        }
    }
    public static void mostrarAdocoesAprovadas() {
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==true){
                System.out.println( "- ID: " + adocao.getIdAdocao());
                System.out.println("NOME DO TUTOR: " + adocao.getCandidato());
                adocao.getAnimal();
            }
            
        }
    }
    public void aprovarAdocao(Adocao a) {
        a.setAprovada(true);
        Animal an = AnimaisDB.validarAnimalPorId(a.getIdAnimalAdocao());
        an.setStatusAdocao(true);
    }
}
