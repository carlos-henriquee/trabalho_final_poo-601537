package db;
import java.util.ArrayList;

import classes_utilitarias.Vacinacao;


public class VacinacoesDB {
    static ArrayList<Vacinacao> vacinacoes = new ArrayList<Vacinacao>();
    
    public static void cadastrarVacinacao(Vacinacao vac) {
        
        vacinacoes.add(vac);
    }
    public static boolean vacinacaoJaExiste(Vacinacao vac){
        if(validarVacinacaoPorAnimal(vac.getNomeAnimal())!=null && validarVacinacaoPorData(vac.getDataAplicacao())!=null)
            return true;
        else return false;
    }
    private static Vacinacao validarVacinacaoPorData(String data) {
        if(vacinacoes.size()==0){
            return null;
        }
        for(Vacinacao vacinacao: vacinacoes) {
            if(vacinacao.getDataAplicacao().equals(data))
                return vacinacao;
        }
        return null;
    }
    private static Vacinacao validarVacinacaoPorAnimal(String nome) {
        if(vacinacoes.size()==0){
            return null;
        }
        for(Vacinacao vacinacao: vacinacoes) {
            if(vacinacao.getNomeAnimal().toLowerCase().trim().equals(nome))
                return vacinacao;
        }
        return null;
    }
    public static void mostrarVacinacoes() {
        if(vacinacoes.size()==0){
            System.out.println("TABELA VAZIA!");
        }
        for(Vacinacao vacinacao: vacinacoes) {
            System.out.print("\n==============================================\n");
            System.out.print("                VACINAÇÕES");
            System.out.print("\n==============================================\n");
            System.out.println( 
                                "- Vacina: " + vacinacao.getNomeVacina() +
                                " | DATA: " + vacinacao.getDataAplicacao()
                            );
        }
    }

}
