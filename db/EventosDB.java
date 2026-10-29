package db;
import java.util.ArrayList;

import classes_utilitarias.Evento;


public class EventosDB {
    static ArrayList<Evento> eventos = new ArrayList<Evento>();
    
    public static void cadastrarEvento(Evento ev) {
        eventos.add(ev);
    }
    public static void mostrarEventos() {
        if(eventos.size()==0){
            System.out.println("TABELA VAZIA!");
        }
        for(Evento evento: eventos) {
            System.out.print("\n==============================================\n");
            System.out.print("                CADASTRAR EVENTO");
            System.out.print("\n==============================================\n");
            System.out.println( 
                                "- Evento: " + evento.getNomeEvento() +
                                "| DATA: " + evento.getDataEvento()
                            );
        }
    }

}
