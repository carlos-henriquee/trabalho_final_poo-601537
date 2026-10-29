package classes_utilitarias;

public class Tratamento {
    private int idTratamento;
    private String nomeAnimal;
    private String especieAnimal;
    private Data inicioTratamento;
    private String prescricao;
    private Data fimTratamento;
    private static int idTratamentoGlobal = 0;

    public Tratamento(String nomeAnimal, String especieAnimal, Data inicioTratamento, String prescricao,Data fimTratamento) 
        throws IllegalArgumentException
    {
        if(especieAnimal==null || especieAnimal.equals("")) 
            throw new IllegalArgumentException("PRESCRICAO NULA OU VAZIA!");
        if(prescricao==null || prescricao.equals("")) 
            throw new IllegalArgumentException("PRESCRICAO NULA OU VAZIA!");
        idTratamentoGlobal++;
        this.idTratamento = idTratamentoGlobal;
        this.nomeAnimal = (nomeAnimal==null || nomeAnimal.equals("")? "SEM NOME" : nomeAnimal);
        this.especieAnimal = especieAnimal;
        this.inicioTratamento = inicioTratamento;
        this.fimTratamento  = fimTratamento;
        this.prescricao = prescricao;
    }
    public int getIdTratamento() {
        return this.idTratamento;
    }
    public String getPrescricao() {
        return this.prescricao;
    }
    public String getInicioTratamento() {
        return  this.inicioTratamento.dia + "/" +
                this.inicioTratamento.mes + "/" +
                this.inicioTratamento.ano; 
    }
    public String getFimTratamento() {
        return  this.fimTratamento.dia + "/" +
                this.fimTratamento.mes + "/" +
                this.fimTratamento.ano; 
    }
    public String getAnimalTratamento() {
        return  "NOME: " + this.nomeAnimal + 
                "| ESPECIE: " + this.especieAnimal;
    }
    public void setNomeAnimal(String novoNomeAnimal) {
        this.nomeAnimal = novoNomeAnimal;
    }
    public void setEspecieAnimal(String novaEspecieAnimal) {
        this.especieAnimal = novaEspecieAnimal;
    }
    public void setPrescricao(String novaPrescricao) {
        this.prescricao = novaPrescricao;
    }
    public void setDataInicio(Data novoInicio) {
        this.inicioTratamento = novoInicio;
    }
    public void setDataFim(Data novoFim) {
        this.fimTratamento = novoFim;
    }
}
