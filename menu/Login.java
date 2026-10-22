package menu;
import java.util.Scanner;
import db.ValidarLogin;



public class Login {
    public static void mostrarInterface() {
        System.out.print("\n=============================================\n");
        System.out.print("                TELA DE LOGIN"                    );
        System.out.print("\n=============================================\n");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ainda não possui uma conta? Cadastre-se como:");
        System.out.println("(1) Voluntário\n(2) Veterinário\n(0) Continuar no Login");
        System.out.print("> ");
        int opcao = entrada.nextInt();
        switch(opcao) {
            case 0:
                System.out.print("Digite seu nome de usuario: ");
                String user = entrada.nextLine();
                System.out.print("\nDigite sua senha: ");
                String senha = entrada.nextLine();
                ValidarLogin.validar(user,senha);
                 
            break;
            case 1: 
                CadastroVoluntario.mostrarInterface();
            break;
        }
        entrada.close();
                       
    }
}
