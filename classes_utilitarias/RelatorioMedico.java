package classes_utilitarias;

import animal.*;

public class RelatorioMedico {
    private Animal animal;
    private String anamnese;
    private double pesoAtualKG;
    

    public RelatorioMedico(String anamnese, double pesoAtualKG) 
        throws IllegalArgumentException
    {
        if(anamnese==null || anamnese.equals(""))
            throw new IllegalArgumentException("ANAMNESE NAO INFORMADA!");
        if(pesoAtualKG<=0)
            throw new IllegalArgumentException("PESO INVALIDO!");

        this.anamnese = anamnese;
        this.pesoAtualKG = pesoAtualKG;
    }


    public void setAnimalRelatorioMedico(Animal an) {
        this.animal = an;
    }
    public String getAnamnese() {
        return this.anamnese;
    }
    public double getPesoAtualRelatorio() {
        return this.pesoAtualKG;
    }
    public String getNomeAnimalRelatorio() {
        return this.animal.nomeAnimal;
    }
    public String getEstadoDeSaudeRelatorio() {
        return this.animal.estadoDeSaude;
    }
}
