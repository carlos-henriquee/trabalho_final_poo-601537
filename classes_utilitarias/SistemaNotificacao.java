package classes_utilitarias;
import java.time.LocalDate;

import db.NotificacoesDB;
import db.VacinasDB;


public class SistemaNotificacao {

    
    private static void vigiarVacinas() {
        int mesAtual = LocalDate.now().getMonthValue();
        for(Vacina vacina: VacinasDB.vacinas) {
            if((vacina.getMesVencimento()-mesAtual)<=1) {
                NotificacoesDB.add("HA UMA VACINA PROXIMA DE VENCER!");
            }
        }
    }
    public static void vigiar() {
        vigiarVacinas();
    }
}
