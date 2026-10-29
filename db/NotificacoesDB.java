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
        for(Notificacao notificacao: notificacoes) {
            System.out.println("[!] " + notificacao.getNotificacaoMessage());
        }
    }

}
