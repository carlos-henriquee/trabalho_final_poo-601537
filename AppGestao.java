import classes_utilitarias.SistemaNotificacao;
import telas.Menu;

public class AppGestao {
    
    public static void main(String[] args) {  
        
        while (true) {
            SistemaNotificacao.vigiar();
            Menu.mostrarInterface();
            break;
        }
    }
}