package classes_utilitarias;

public class Vacina {
    private String nomeVacina;
    private int qtdDoses;
    private Data dataVencimento;

    public Vacina(String nomeVacina, int qtdDoses, Data dataVencimento) 
        throws IllegalArgumentException
    {
        if(nomeVacina==null || nomeVacina.equals(""))
            throw new IllegalArgumentException("NOME DA VACINA NAO INFORMADO!");
        if(qtdDoses<=0)
            throw new IllegalArgumentException("QUANTIDADE DE DOSES INVALIDAS!");
        if(dataVencimento==null)
            throw new IllegalArgumentException("VENCIMENTO DA VACINA NAO INFORMADO!");
        this.dataVencimento = dataVencimento;
        this.nomeVacina = nomeVacina;
        this.qtdDoses = qtdDoses;
    }


    public String getNomeVacina() {
        return this.nomeVacina;
    }
    public int getQuantidadeDoses() {
        return this.qtdDoses;
    }

    public void setNovaQuantidadeDoses(int novaQuantidade) {
        this.qtdDoses = novaQuantidade;
    }
    public String getDataVencimento() {
        return this.dataVencimento.getData();
    }
    public int getMesVencimento() {
        return this.dataVencimento.getMes();
    }



}
