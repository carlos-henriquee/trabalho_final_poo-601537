package classes_utilitarias;

import java.util.ArrayList;
import usuario.Voluntario;


public class Evento {
    private static int idEventosGlobal;
    private int idEvento;
    private String nomeEvento;
    private Data dataEvento;
    private ArrayList<Voluntario> voluntarios;


    public Evento(String nomeEvento, Data dataEvento) 
        throws IllegalArgumentException
    {
        if(nomeEvento==null || nomeEvento.equals(""))
            throw new IllegalArgumentException("EVENTO COM NOME NULO OU VAZIO");
        if(dataEvento==null)
            throw new IllegalArgumentException("DATA NULA");
        idEventosGlobal++;
        this.idEvento = idEventosGlobal;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }
    public void inscreverVoluntario(Voluntario v) {
        voluntarios.add(v);
    }
    public void mostrarVoluntariosInscritos() {
        for(Voluntario voluntario: voluntarios) {
            System.out.println("- NOME: " + voluntario.nome);
        }
    }
    public int getIdEvento() {
        return this.idEvento;
    }
    public String getNomeEvento() {
        return this.nomeEvento;
    }
    public String getDataEvento() {
        return dataEvento.getData();
    }
    public int getMesEvento() {
        return this.dataEvento.getMes();
    }
    public void setNovoNomeEvento(String novoNome) {
        this.nomeEvento  = novoNome;
    }
    public void setNovaDataEvento(Data novaData) {
        this.dataEvento = novaData;
    }
}
