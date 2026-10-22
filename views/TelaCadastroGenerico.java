package views;
import java.util.Scanner;

import views.voluntario.CadastroVoluntario;
public class TelaCadastroGenerico{

    public static void mostrarInterface() {
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
                Menu.mostrarInterface();
            break;
            default:
                System.out.println("Opcao invalida! Voltando para menu principal...");
                Menu.mostrarInterface();
            break;
        }
        entrada.close();
    }
}
