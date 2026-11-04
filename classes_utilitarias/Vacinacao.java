package classes_utilitarias;

import db.AnimaisDB;
import exceptions.AnimalNaoEncontradoException;

public class Vacinacao {
    private String nomeVacina;
    private String nomeAnimal;
    private Data dataAplicacao;
    public Vacinacao(String nomeVacina, String nomeAnimal, Data dataAplicacao) 
        throws IllegalArgumentException,
        AnimalNaoEncontradoException
    {
        if(nomeVacina==null || nomeVacina.equals(""))
            throw new IllegalArgumentException("NOME DA VACINA NAO INFORMADO!");
        if(nomeAnimal==null || nomeAnimal.equals(""))
            throw new AnimalNaoEncontradoException("ID DO ANIMAL INVALIDO OU NAO INFORMADO!");

        
        if(AnimaisDB.validarAnimalPorNome(nomeAnimal)==null)
            throw new AnimalNaoEncontradoException("NAO EXISTE ANIMAL COM ESSE NOME!");
        this.nomeVacina = nomeVacina;
        this.nomeAnimal = nomeAnimal;
        this.dataAplicacao = dataAplicacao;
    }

    public String getNomeVacina() {
        return this.nomeVacina;
    }
    public String getNomeAnimal() {
        return this.nomeAnimal;
    }
    public String getDataAplicacao() {
        return this.dataAplicacao.getData();
    }

}
