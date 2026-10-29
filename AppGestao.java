import telas.Menu;
import classes_utilitarias.SistemaNotificacoes;

public class AppGestao {
    public static void main(String[] args) {
        
        Menu.mostrarInterface();
        while(true) {
            SistemaNotificacoes.escutar();
        }
    }
}