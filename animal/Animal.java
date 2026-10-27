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
    public String statusDeAdocao;

    private static int idAnimalGlobal = 0;

    public Animal(
        String nomeAnimal, 
        String especie, 
        String raca, 
        int idade, 
        Porte porte, 
        String estadoDeSaude, 
        Data dataDeResgate, 
        String statusDeAdocao
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
        this.statusDeAdocao = statusDeAdocao;
    }

    public String getPorte() {
        return this.porte.porte;
    }
    public String getDataResgate() {
        return  this.dataDeResgate.dia + "/" + this.dataDeResgate.mes + "/" + this.dataDeResgate.ano;
    }

}
