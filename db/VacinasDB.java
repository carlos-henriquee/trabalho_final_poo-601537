package db;

import java.util.ArrayList;
import classes_utilitarias.Vacina;
public class VacinasDB {
    public static ArrayList<Vacina> vacinas = new ArrayList<Vacina>();

    public static void cadastrarVacina(Vacina vacina) {
        vacinas.add(vacina);
        NotificacoesDB.add("NOVA VACINA CADASTRADA!");
    }

    public static void mostrarVacinas() {
        if(vacinas.size()==0) {
            System.out.println("TABELA VAZIA!");
        }
        for(Vacina vacina: vacinas) {
            System.out.println( "- Vacina: " + vacina.getNomeVacina() + 
                                " | Estoque de doses: " + vacina.getQuantidadeDoses()
                            );
        }
    }
    public static Vacina validarVacinaPorNome(String nomeVacina) {
        String nome = nomeVacina.toLowerCase().trim();

        if(vacinas.size()==0){
            return null;
        }
        for(Vacina vacina : vacinas) {
            if(vacina.getNomeVacina().toLowerCase().trim().equals(nome)){
                return vacina;
            }
        }
        return null;

    }

}
