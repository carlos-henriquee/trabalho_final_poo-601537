package classes_utilitarias;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.EventosDB;
import db.NotificacoesDB;
import db.VacinasDB;


public class SistemaNotificacao {
    
    private static void vigiarVacinas() {
        int mesAtual = LocalDate.now().getMonthValue();

        LocalDate dataAtual  = LocalDate.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String dataFormatada = dataAtual.format(formatador);
        
        for(Vacina vacina: VacinasDB.vacinas) {
            if((vacina.getMesVencimento()-mesAtual)<=1) {
                NotificacoesDB.add("HA UMA VACINA PROXIMA DE VENCER!");
            }
            if(vacina.getDataVencimento().equals(dataFormatada)){
                NotificacoesDB.add("UMA VACINA ACABOU DE VENCER!");
            }
        }
    }
    public static void vigiarEventos() {
        int mesAtual = LocalDate.now().getMonthValue();

        LocalDate dataAtual  = LocalDate.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String dataFormatada = dataAtual.format(formatador);
        
        for(Evento evento: EventosDB.eventos) {
            if((evento.getMesEvento()-mesAtual)<=1) {
                NotificacoesDB.add("HA UM EVENTO PROXIMO DE ACONTECER!");
            }
            if(evento.getDataEvento().equals(dataFormatada)){
                NotificacoesDB.add("HA UM EVENTO PARA HOJE!");
            }
        }
    }
    public static void vigiar() {
        vigiarVacinas();
        vigiarEventos();
    }
    public static boolean fechar() {
        return false;
    }
}
