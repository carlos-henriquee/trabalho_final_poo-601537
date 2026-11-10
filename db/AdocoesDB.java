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
        if(adocoes.size()==0) {
            System.out.println("SEM ADOÇÕES PENDENTES");
            return;
        }
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==false){
                System.out.println("========================================================================");
                System.out.println("ID DA SOLICITAÇÃO: " + adocao.getIdAdocao());
                System.out.println("========================================================================");
                System.out.println("========================================================================");
                System.out.println("ANIMAL");
                adocao.getAnimal();
                System.out.println("========================================================================");
                System.out.println("========================================================================");
                adocao.getCandidatos();
                System.out.println("========================================================================");
                
                
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
        boolean encontrou = false;
                System.out.println("========================================================================");
                System.out.println("                          ADOÇOES APROVADAS                             ");
                System.out.println("========================================================================");
        for(Adocao adocao : adocoes) {
            if(adocao.foiAprovada()==true){
                encontrou = true;
                System.out.println( "- ID DA ADOÇÃO: " + adocao.getIdAdocao());
                adocao.getAnimal();
                System.out.println("CANDIDATO ESCOLHIDO: " + adocao.getCandidatoEscolhido());
            }
        }
        if(encontrou==false) System.out.println("NENHUMA ADOÇÃO FOI APROVADA");
    }
}
