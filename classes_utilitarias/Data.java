package classes_utilitarias;

public class Data {
    public int dia;
    public int mes;
    public int ano;
    public Data(int dia, int mes, int ano) 
    throws IllegalArgumentException
    {
        if((dia<=0||mes<=0||ano<=0) || (dia>31 || mes>12)) {
            throw new IllegalArgumentException("DATA INVALIDA");
        }else{
            this.dia = dia;
            this.mes = mes;
            this.ano  = ano;
        }
    }
    public int getDia() {
        return this.dia;
    }
    public int getMes() {
        return this.mes;
    }
    public int getAno() {
        return this.ano;
    }

    public String getData() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
