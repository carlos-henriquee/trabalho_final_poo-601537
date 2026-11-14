package db;

import java.util.ArrayList;

import classes_utilitarias.Consulta;
public class ConsultasDB {
    public static ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    public static int quantidadeDeConsultasRealizadas = 0;
    public static void cadastrarConsulta(Consulta c) {
        if(c==null) throw new IllegalArgumentException("CONSULTA INVALIDA");
        consultas.add(c);
        System.out.println("CONSULTA CADASTRADA!");
    }
    public static void mostrarConsultas() {
        if(consultas.size()==0){
            System.out.println("TABELA VAZIA!");
            return;
        }
        System.out.print("\n==============================================\n");
        System.out.print("                CONSULTAS CADASTRADAS");
        System.out.print("\n==============================================\n");
        for(Consulta consulta : consultas) {
            System.out.println( " - ID: " + consulta.getIdConsulta() + 
                                " | Animal: " + consulta.getNomeAnimal() + 
                                " | Data: " + consulta.getDataConsulta()
                            );
        }
    }
    public static void concluirConsulta(int idConsulta) {

        for(Consulta c : consultas) {
            if(c.getIdConsulta()==idConsulta) {
                consultas.remove(c);
                return;
            }
        }
        System.out.println("CONSULTA NAO ENCONTRADA");
    }   
    public static int getQuantidadeConsultasRealizadas() {
        return quantidadeDeConsultasRealizadas;
    }
}
