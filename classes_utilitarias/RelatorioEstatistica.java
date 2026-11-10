package classes_utilitarias;
import db.AdocoesDB;
import db.AnimaisDB;
import db.ConsultasDB;
import db.UsuariosDB;


public class RelatorioEstatistica {
    public static void mostrarRelatorio() {
        while(true) {
            System.out.print("\n====================================================\n");
            System.out.print("                RELATORIO E ESTATISTICAS");
            System.out.print("\n====================================================\n");
            System.out.println("Quantidade de animais cadastrados: " + AnimaisDB.getQuantidadeAnimaisCadastrados());
            System.out.println("Quantidade de consultas realizdas: " + ConsultasDB.quantidadeDeConsultasRealizadas);
            System.out.println("Quantidade de adoções aprovadas: " + AdocoesDB.getQuantidadeAdocoesAprovadas());
            System.out.println("Quantidade de voluntários ativos: " + UsuariosDB.getQuantidadeVoluntariosAtivos());
            System.out.println("Quantidade de animais em tratamento: " + AnimaisDB.getAnimaisEmTratamentos());
            if(AnimaisDB.getQuantidadeAnimaisCadastrados()>0) {
                System.out.println("Taxa de adoção: "+(AdocoesDB.getQuantidadeAdocoesAprovadas()/AnimaisDB.getQuantidadeAnimaisCadastrados())*100 + "%");
            }else {
                System.out.println("Taxa de adoção mensal: 0%");
            }
            return;
        }
        
    }
}
