package usuario;

import java.util.ArrayList;

import classes_utilitarias.Evento;
import animal.Animal;

public class Voluntario extends Usuario{
    private ArrayList<Evento> eventosInscritos = new ArrayList<Evento>();
    private ArrayList<Animal> meusAnimais = new ArrayList<Animal>(); 
    public Voluntario (String nome, String nomeDeUsuario, String senha) 
        throws IllegalArgumentException 
    {
        super(nome, nomeDeUsuario, senha);
    }
    public void adicionarAnimal(Animal animal) {
        meusAnimais.add(animal);
    }
    public void mostrarMeusAnimais() {
        if(meusAnimais.size()==0) {
            System.out.println("TABELA VAZIA!");
            return;
        }
        for(Animal an: meusAnimais) {
            System.out.println(" - Nome do animal: " + an.nomeAnimal);
        }
    }
    public void removerAnimal(Animal a) {
        meusAnimais.remove(a);
    }
    public void adicionarEvento(Evento ev) {
        eventosInscritos.add(ev);
    }
    public void mostrarEventosInscritos() {
        if(eventosInscritos.size()==0) {
            System.out.println("TABELA VAZIA!");
            return;
        }
        for(Evento ev: eventosInscritos) {
            System.out.println("- Evento: " + ev.getNomeEvento() + " | DATA: " + ev.getDataEvento());
        }
    }
}
