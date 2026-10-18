package classes_utilitarias;

public class Data {
    public int dia;
    public int mes;
    public int ano;
    public Data(int dia, int mes, int ano) {
        if((dia<=0||mes<=0||ano<=0) || (dia>31 || mes>12 || ano>2026)) {
            System.out.println("DATA INVALIDA");
        }else{
            this.dia = dia;
            this.mes = mes;
            this.ano  = ano;
        }
    }
}
