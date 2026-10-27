package telas;

import java.util.Scanner;

import db.UsuariosDB;
import usuario.*;
import telas.voluntario.CadastroVoluntario;
import telas.veterinario.CadastroVeterinario;
import telas.admin.TelaAdmin;
import telas.veterinario.PainelVeterinario;
import telas.voluntario.PainelVoluntario;

public class TelaLogin {
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
            
            case 1: 
                CadastroVoluntario.mostrarInterface();
            break;
            case 2:
                CadastroVeterinario.mostrarInterface();
            break;
            case 0:
                Scanner inputLogin = new Scanner(System.in);
                System.out.print("\nNome de usuario: ");
                String user = inputLogin.nextLine();

                System.out.print("\nSenha: ");
                String senha = inputLogin.nextLine();

                if(user.equals("admin") && senha.equals("admin"))
                    TelaAdmin.mostrarInterface();
                Usuario usuarioLogado = UsuariosDB.logar(user,senha);
                if(usuarioLogado==null){
                    System.out.println("NAO FOI POSSIVEL LOGAR");
                }else if(usuarioLogado instanceof Voluntario) {
                    System.out.println("LOGIN REALIZADO COM SUCESSO");
                    PainelVoluntario.mostrarInterface(usuarioLogado.nome);
                }else if(usuarioLogado instanceof Veterinario) {
                    System.out.println("LOGIN REALIZADO COM SUCESSO!");
                    PainelVeterinario.mostrarInterface(usuarioLogado.nome);
                }
                inputLogin.close();
            break;
            
            default:
            break;
        }
        entrada.close();
    }
}

