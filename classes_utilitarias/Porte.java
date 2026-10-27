package classes_utilitarias;

public class Porte {
    public String porte;
    public Porte(String porte) 
        throws IllegalArgumentException
    {
        if(porte==null){
            throw new IllegalArgumentException("PORTE NULO");
        }else if(porte.equals("grande")||porte.equals("medio")||porte.equals("pequeno")) {
            this.porte = porte;
        }else if(porte.equals("")){
            throw new IllegalArgumentException("PORTE VAZIO");
        }else{
            throw new IllegalArgumentException("PORTE INVALIDO");
        }
    }
}
