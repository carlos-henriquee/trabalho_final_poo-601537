package classes_utilitarias;

public class Consulta {
    private int idConsulta;
    private String nomeAnimal;
    private Data dataConsulta;
    private static int idConsultaGlobal = 0;

    public Consulta(String nomeAnimal, String nomeTutor, Data dataConsulta) 
        throws IllegalArgumentException
        {
        if(nomeAnimal==null || nomeAnimal.equals(""))
            throw new IllegalArgumentException("NOME DO ANIMAL NAO INFORMADO");
        if(dataConsulta==null)
            throw new IllegalArgumentException("DATA DA CONSULTA NAO INFORMADA");
        
        idConsultaGlobal++;

        this.idConsulta = idConsultaGlobal;
        this.nomeAnimal = nomeAnimal;
        this.dataConsulta = dataConsulta;
    }
    public int getIdConsulta() {
        return this.idConsulta;
    }
    public String getNomeAnimal() {
        return this.nomeAnimal;
    }
    
    public Data getDataConsulta() {
        return this.dataConsulta;
    }
}
