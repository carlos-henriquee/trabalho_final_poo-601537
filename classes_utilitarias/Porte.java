package classes_utilitarias;

public class Porte {
    public String porte;
    public Porte(String porte) {
        if(porte.equals("grande")||porte.equals("medio")||porte.equals("pequeno")) {
            this.porte = porte;
        }else{
            System.out.println("PORTE INVALIDO");
        }
    }
}
