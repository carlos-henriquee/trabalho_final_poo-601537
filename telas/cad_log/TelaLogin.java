package telas.cad_log;



import classes_utilitarias.Leitura;
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
        System.out.println("Ainda não possui uma conta? Cadastre-se como:");
        System.out.println("(1) Voluntário\n(2) Veterinário\n(3) Continuar no Login\n(0) Voltar");
        int opcao = Leitura.lerNumero("\n> ");

        switch(opcao) {
            case 0:
                return;
            case 1: 
                CadastroVoluntario.mostrarInterface();
            break;
            case 2:
                CadastroVeterinario.mostrarInterface();
            break;
            case 3:
                String user = Leitura.lerTexto("\nNome de usuario: ");

                String senha = Leitura.lerTexto("\nSenha: ");

                if(user.equals("admin") && senha.equals("admin"))
                    TelaAdmin.mostrarInterface();
                Usuario usuarioLogado = UsuariosDB.logar(user,senha);
                if(usuarioLogado==null){
                    System.out.println("NAO FOI POSSIVEL LOGAR");
                }else if(usuarioLogado instanceof Voluntario) {
                    System.out.println("LOGIN REALIZADO COM SUCESSO");
                    Voluntario voluntario  = (Voluntario)usuarioLogado;
                    PainelVoluntario.mostrarInterface(voluntario);
                }else if(usuarioLogado instanceof Veterinario) {
                    System.out.println("LOGIN REALIZADO COM SUCESSO!");
                    PainelVeterinario.mostrarInterface();
                }
            break;
            
            default:
            break;
        }
    
    }
}

