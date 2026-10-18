package animal;

import classes_utilitarias.Data;
import classes_utilitarias.Porte;


public class Animal {
    public String nome;
    public String especie;
    public String raca;
    public int idade;
    public Porte porte;
    public String estadoDeSaude;
    public Data dataDeResgate;
    public String statusDeAdocao;

    public Animal(
        String nome, 
        String especie, 
        String raca, 
        int idade, 
        Porte porte, 
        String estadoDeSaude, 
        Data dataDeResgate, 
        String statusDeAdocao
    ) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
        this.estadoDeSaude = estadoDeSaude;
        this.dataDeResgate = dataDeResgate;
        this.statusDeAdocao = statusDeAdocao;
    }



}
