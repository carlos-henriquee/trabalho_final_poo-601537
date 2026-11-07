import classes_utilitarias.SistemaNotificacao;
import telas.Menu;

public class AppGestao {
    
    public static void main(String[] args) {
        
        Menu.mostrarInterface();
        while (true) {
            SistemaNotificacao.vigiar();
        }
    }
}