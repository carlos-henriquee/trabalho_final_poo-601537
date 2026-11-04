package db;
import java.util.ArrayList;

import classes_utilitarias.Notificacao;


public class NotificacoesDB {
    static ArrayList<Notificacao> notificacoes = new ArrayList<Notificacao>();

    public static void add(String msg) {
        Notificacao novaNotificacao = new Notificacao(msg);

        notificacoes.add(novaNotificacao);
    }
    public static void mostrarNotificacoes() {
        if(notificacoes.size()==0) System.out.println("///////////////\nSEM NOTIFICAÇÕES\n///////////////");
        
            System.out.print("\n=========================================\n");
            System.out.print("                NOTIFICAÇÕES               ");
            System.out.print("\n===============================================\n");
        
        for(Notificacao notificacao: notificacoes) {
            System.out.println("[!] " + notificacao.getNotificacaoMessage());
        }
    }

}
