package views;
import java.util.Scanner;

import db.UsuariosDB;
import views.admin.TelaAdmin;
import views.voluntario.CadastroVoluntario;


public class TelaLogin {
    public static void mostrarInterface() {
        System.out.print("\n=============================================\n");
        System.out.print("                TELA DE LOGIN"                    );
        System.out.print("\n=============================================\n");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ainda não possui uma conta? Cadastre-se como:");
        System.out.println("(1) Voluntário\n(2) Veterinário\n(3) Continuar no Login");
        System.out.print("> ");
        int opcao = entrada.nextInt();

        switch(opcao) {
            
            case 1: 
                CadastroVoluntario.mostrarInterface();
            break;
            case 2:
                CadastroVoluntario.mostrarInterface();
            break;
            case 3:
                Scanner inputLogin = new Scanner(System.in);
                System.out.print("\nNome de usuario: ");
                String user = inputLogin.nextLine();

                System.out.print("\nSenha: ");
                String senha = inputLogin.nextLine();

                if(user.equals("admin") && senha.equals("admin"))
                    TelaAdmin.mostrarInterface();
                UsuariosDB.logar(user, senha);
                 inputLogin.close();
            break;
            default:
            break;
        }
        entrada.close();
    }
}
