package classes_utilitarias;
import java.util.ArrayList;

import animal.Animal;
import db.AdocoesDB;
import db.AnimaisDB;
import db.ConsultasDB;
import db.UsuariosDB;


public class RelatorioEstatistica {
    private static void relatorioEspecies(ArrayList<Animal> animais) {
                if (animais.isEmpty()) {
                    System.out.println("Nenhum animal cadastrado.");
                    return;
                }

                ArrayList<String> especies = new ArrayList<>();
                ArrayList<Integer> quantidades = new ArrayList<>();

                
                for (Animal a : animais) {
                    String especie = a.especie;
                    int pos = especies.indexOf(especie); 

                    if (pos == -1) {
                        especies.add(especie);
                        quantidades.add(1);
                    } else {
                        quantidades.set(pos, quantidades.get(pos) + 1);
                    }
                }

               
                for (int i = 0; i < especies.size() - 1; i++) {
                    for (int j = 0; j < especies.size() - 1 - i; j++) {
                        if (quantidades.get(j) < quantidades.get(j + 1)) {
                           
                            int qtdTemp = quantidades.get(j);
                            quantidades.set(j, quantidades.get(j + 1));
                            quantidades.set(j + 1, qtdTemp);

                            String espTemp = especies.get(j);
                            especies.set(j, especies.get(j + 1));
                            especies.set(j + 1, espTemp);
                        }
                    }
                }

                
                System.out.println("=== ESPÉCIES MAIS RESGATADAS ===");
                for (int i = 0; i < especies.size(); i++) {
                    System.out.println((i + 1) + "º " + especies.get(i) + ": " + quantidades.get(i));
                }
            }
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
                System.out.println("Taxa de adoção: 0%");
            }
            relatorioEspecies(AnimaisDB.getAnimaisCadastrados());
            return;
        }
        
    }
}
