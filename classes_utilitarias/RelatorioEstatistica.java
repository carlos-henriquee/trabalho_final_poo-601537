package classes_utilitarias;
import db.AdocoesDB;
import db.AnimaisDB;
import db.ConsultasDB;


public class RelatorioEstatistica {
    public static void mostrarRelatorio() {
        while(true) {
            System.out.print("\n====================================================\n");
            System.out.print("                RELATORIO E ESTATISTICAS");
            System.out.print("\n====================================================\n");
            System.out.println("Quantidade de animais cadastrados: " + AnimaisDB.getQuantidadeAnimaisCadastrados());
            System.out.println("Quantidade de consultas realizdas: " + ConsultasDB.quantidadeDeConsultasRealizadas);
            System.out.println("Quantidade de adoções aprovadas: " + AdocoesDB.getQuantidadeAdocoesAprovadas());
            return;
        }
        
    }
}
