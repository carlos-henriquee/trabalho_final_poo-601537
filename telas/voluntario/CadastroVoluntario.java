package telas.voluntario;



import classes_utilitarias.Leitura;
import db.UsuariosDB;
import usuario.Usuario;
import usuario.Voluntario;

public class CadastroVoluntario {
    public static void mostrarInterface() {
        System.out.print("\n==================================================\n");
        System.out.print("           TELA DE CADASTRO DE VOLUNTARIOS            ");
        System.out.print("\n==================================================\n");
       
        String nome = Leitura.lerTexto("\nDigite seu nome: ");
        String nomeDeUsuario = Leitura.lerTexto("\nDigite seu nome de usuário: ");


        System.out.println("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
        String senha = Leitura.lerTexto("\n> ");
        

        try {
            Usuario voluntario = new Voluntario(nome, nomeDeUsuario, senha);
            UsuariosDB.cadastrar(voluntario);
        } catch (IllegalArgumentException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        }
        
        
        
    }

}
