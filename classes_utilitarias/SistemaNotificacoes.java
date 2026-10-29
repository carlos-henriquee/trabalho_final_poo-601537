package classes_utilitarias;
import db.NotificacoesDB;
import db.TratamentosDB;

public class SistemaNotificacoes {
    private static void escutarTratamentos() {
        for(Tratamento tratamento : TratamentosDB.tratamentos) {
            if(tratamento.getFimTratamento().equals("29/10/2026")){
                NotificacoesDB.add("O TRATAMENTO #"+ tratamento.getIdTratamento()+ " FINALIZARA HOJE");
            }

        }
    }

    public static void escutar() {
        escutarTratamentos();
    }
}
