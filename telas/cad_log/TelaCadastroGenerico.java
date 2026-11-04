package telas.cad_log;


import classes_utilitarias.Leitura;
import telas.voluntario.CadastroVoluntario;
import telas.Menu;
import telas.veterinario.CadastroVeterinario;
public class TelaCadastroGenerico{

    public static void mostrarInterface() {
        while(true) {
            System.out.print("\n==============================================\n");
            System.out.print("                TELA DE CADASTRO");
            System.out.print("\n==============================================\n");
            System.out.println("Como deseja se cadastrar?");
            System.out.println("(1) Voluntario\n(2) Veterinario\n(0) Voltar");

            int opcao = Leitura.lerNumero("\n> ");

            switch (opcao) {
                case 0:
                    return;
                case 1:
                    CadastroVoluntario.mostrarInterface();
                    return;
                
                
                case 2:
                    CadastroVeterinario.mostrarInterface();
                    return;
                 
                
                default:
                    System.out.println("Opcao invalida! Voltando para menu principal...");
                    Menu.mostrarInterface();
                break;
            }
        }
    }
}
