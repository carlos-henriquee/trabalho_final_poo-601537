package animal;

import classes_utilitarias.Data;
import classes_utilitarias.Porte;


public class Animal {
    public int idAnimal;
    public String nomeAnimal;
    public String especie;
    public String raca;
    public int idade;
    public Porte porte;
    public String estadoDeSaude;
    public Data dataDeResgate;
    public boolean adotado;
    public String nomeVoluntarioResponsavel;
    public boolean emTratamento;

    private static int idAnimalGlobal = 0;

    public Animal(
        String nomeAnimal, 
        String especie, 
        String raca, 
        int idade, 
        Porte porte, 
        String estadoDeSaude, 
        Data dataDeResgate, 
        boolean adotado,
        String nomeVoluntarioResponsavel
    ) {
        idAnimalGlobal++;
        this.idAnimal = idAnimalGlobal;
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.estadoDeSaude = estadoDeSaude;
        this.dataDeResgate = dataDeResgate;
        this.adotado = adotado;
        this.nomeVoluntarioResponsavel = nomeVoluntarioResponsavel;
    }
    public String getVoluntarioResponsavel() {
        return nomeVoluntarioResponsavel.length()>0?nomeVoluntarioResponsavel:"SEM RESPONSAVEL";
    }
    public String getPorte() {
        return this.porte.porte;
    }
    public String getDataResgate() {
        return  this.dataDeResgate.getData();
    }
    public boolean foiAdotado() {
        return this.adotado;
    }
    public void setStatusAdocao(boolean status) {
        this.adotado = status;
    }


    //setters
    public void setNovoNome(String novoNome) {
        if(novoNome!=null && !novoNome.equals("")){
            this.nomeAnimal = novoNome;
        }
    }
    public void setNovaIdade(int novaIdade) {
        if(novaIdade<=0) {
            System.out.println("IDADE INVALIDA!");
            return;
        }
        this.idade = novaIdade;
    }
    public void setNovoPorte(Porte novoPorte) {
        this.porte = novoPorte;
    }
    public void setNovoEstadoDeSaude(String novoEstado) {
        this.estadoDeSaude = novoEstado;
    }
}
