package db;

import java.util.ArrayList;
import animal.*;
import classes_utilitarias.RelatorioMedico;

public class RelatoriosMedicosDB {
    static ArrayList<RelatorioMedico>  relatorioMedicos = new ArrayList<RelatorioMedico>();

    public static void registrarRelatorio(RelatorioMedico rm) {
        relatorioMedicos.add(rm);
    }
    public static void exibirRelatorioPorAnimal(Animal an) {
        if(relatorioMedicos.size()==0){
            System.out.println("TABELA VAZIA!");
            return;
        }
        for(RelatorioMedico rm : relatorioMedicos) {
            if(rm.getNomeAnimalRelatorio().toLowerCase().trim().equals(an.nomeAnimal.toLowerCase().trim())){
                System.out.println( "- Animal: " + rm.getNomeAnimalRelatorio()+
                                    "\n  Estado de saúde: " + rm.getEstadoDeSaudeRelatorio() +
                                    "\n  Anamnese: " + rm.getAnamnese());
            }
        }
    }

}
