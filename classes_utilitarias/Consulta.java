package classes_utilitarias;

public class Consulta {
    private int idConsulta;
    private String nomeAnimal;
    private String especieAnimal;
    private Data dataConsulta;
    private static int idConsultaGlobal = 0;

    public Consulta(String nomeAnimal, String especieAnimal, Data dataConsulta) 
        throws IllegalArgumentException
        {
        if(especieAnimal==null || especieAnimal.equals(""))
            throw new IllegalArgumentException("NOME DO ANIMAL NAO INFORMADO");
        if(dataConsulta==null)
            throw new IllegalArgumentException("DATA DA CONSULTA NAO INFORMADA");
        
        idConsultaGlobal++;

        this.idConsulta = idConsultaGlobal;
        this.nomeAnimal = nomeAnimal;
        this.especieAnimal = especieAnimal;
        this.dataConsulta = dataConsulta;
    }
    public int getIdConsulta() {
        return this.idConsulta;
    }
    public String getNomeAnimal() {
        return this.nomeAnimal;
    }
    public String getEspecieAnimal() {
        return this.especieAnimal;
    }
    public Data getDataConsulta() {
        return this.dataConsulta;
    }
}
