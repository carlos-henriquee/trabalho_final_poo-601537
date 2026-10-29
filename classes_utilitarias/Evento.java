package classes_utilitarias;

public class Evento {
    private String nomeEvento;
    private Data dataEvento;

    public Evento(String nomeEvento, Data dataEvento) 
        throws IllegalArgumentException
    {
        if(nomeEvento==null || nomeEvento.equals(""))
            throw new IllegalArgumentException("EVENTO COM NOME NULO OU VAZIO");
        if(dataEvento==null)
            throw new IllegalArgumentException("DATA NULA");
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }
    public String getNomeEvento() {
        return this.nomeEvento;
    }
    public String getDataEvento() {
        return    this.dataEvento.dia + "/" 
                + this.dataEvento.mes + "/" 
                + this.dataEvento.ano;
    }
}
