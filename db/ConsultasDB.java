package db;

import java.util.ArrayList;

import classes_utilitarias.Consulta;
public class ConsultasDB {
    public static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    public static void cadastrarConsulta(Consulta c) {
        if(c==null) throw new IllegalArgumentException("CONSULTA INVALIDA");
        consultas.add(c);
    }
    public static void mostrarConsultas() {
        for(Consulta consulta : consultas) {
            System.out.println( " - ID: " + consulta.getIdConsulta() + 
                                " | Animal: " + consulta.getNomeAnimal() + 
                                " | Data: " + consulta.getDataConsulta()
                            );
        }
    }

}
