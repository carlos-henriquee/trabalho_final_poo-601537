package menu;
import java.util.Scanner;
public class CadastroGenerico {
    public static void opcoesDeCadastro() {
        System.out.print("\n==============================================\n");
        System.out.print("                MENU PRINCIPAL");
        System.out.print("\n==============================================\n");
        System.out.println("Como deseja se cadastrar?");
        System.out.println("(1) Voluntario\n(2) Veterinario\n(0) Voltar");
        Scanner entrada = new Scanner(System.in);
        System.out.print("> ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                CadastroVoluntario.mostrarInterface();
            break;
            
            case 2:
                ///VETERINARIO
            break;  
            case 0:
                System.out.println("VOLTANDO PARA O MENU PRINCIPAL...");
                Menu.mostrarOpcoes();
            break;
            default:
                System.out.println("Opcao invalida! Voltando para menu principal...");
                Menu.mostrarOpcoes();
            break;
        }
        entrada.close();
    }
}
