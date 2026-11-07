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
        NotificacoesDB.add("NOVA SOLICITAÇÃO DE ADOÇÃO!");
    }
    public static int getQuantidadeAdocoesAprovadas() {
        return adocoes.size();
    }
    public static Adocao validarAdocaoPorId(int id) {
        if(adocoes.size()==0) {
            return null;
        }
        for(Adocao ad: adocoes) {
            if(ad.getIdAdocao()==id) {
                return ad;
            }
        }
        return null;
    }
    public static void mostrarAdocoesPendentes() {
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==false){
                System.out.println("ID DA SOLICITAÇÃO: " + adocao.getIdAdocao());
                adocao.getAnimal();
                adocao.getCandidatos();
            }
            
        }
    }
    public static Adocao validarAdocao(String nomeAnimal) {
        Animal an = AnimaisDB.validarAnimalPorNome(nomeAnimal);
        for(Adocao adocao : adocoes) {
            if(adocao.getIdAnimalAdocao()==an.idAnimal) {
                return adocao;
            }
        }
        return null;
    }
    public static void mostrarAdocoesAprovadas() {
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==true){
                System.out.println( "- ID DA ADOÇÃO: " + adocao.getIdAdocao());
                adocao.getAnimal();
                System.out.println("CANDIDATO ESCOLHIDO: " + adocao.getCandidatoEscolhido());
            }
            
        }
    }
}
