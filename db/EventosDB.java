package db;
import java.util.ArrayList;

import classes_utilitarias.Evento;
import usuario.*;

public class EventosDB {
    public static ArrayList<Evento> eventos = new ArrayList<Evento>();
    public static int quantidadeEventos = eventos.size();
    public static void cadastrarEvento(Evento ev) {
        eventos.add(ev);
        NotificacoesDB.add("NOVO EVENTO CADASTRADO!");
    }
    public static void mostrarEventos() {
            System.out.print("\n==============================================\n");
            System.out.print("                EVENTOS CADASTRADOS");
            System.out.print("\n==============================================\n");
        if(eventos.size()==0){
            System.out.println("TABELA VAZIA!");
        }
        for(Evento evento: eventos) {
            
            System.out.println( " - ID DO EVENTO: " + evento.getIdEvento() +
                                "- Evento: " + evento.getNomeEvento() +
                                " | DATA: " + evento.getDataEvento()
                            );
            System.out.println("VOLUNTARIOS CADASTRADOS: ");
            for(Voluntario voluntario : evento.voluntarios) {
                System.out.println("Voluntario: " + voluntario.nome);
            }
            
        }
    }
    public static Evento validarEventoPorId(int idEvento) {
        if(eventos.size()==0)
            return null;
        for(Evento ev: eventos) {
            if(ev.getIdEvento()==idEvento)
                return ev;
        }
        return null;
    }
}
