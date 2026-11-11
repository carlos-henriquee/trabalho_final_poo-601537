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
        
        while(nome==null || nome.equals("")) {
            System.out.println("NOME NAO INFORMADO!");
            nome = Leitura.lerTexto("\nDigite seu nome: ");
        }

        String nomeDeUsuario = Leitura.lerTexto("\nDigite seu nome de usuário: ");

        while(nomeDeUsuario==null || nomeDeUsuario.equals("")) {
            System.out.println("NOME DE USUARIO NAO INFORMADO!");
            nome = Leitura.lerTexto("\nDigite seu nome de usuário: ");
        }

        Usuario jaExiste = UsuariosDB.validarUsuarioPorNomeDeUsuario(nomeDeUsuario);
        if(jaExiste!=null) {
            System.out.println("JA EXISTE UM USUARIO COM ESSE USERNAME!");
            return;
        }

        System.out.println("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
        String senha = Leitura.lerTexto("\n> ");
        while(senha==null || senha.equals("")) {
            System.out.println("SENHA NAO INFORMADA!");
            System.out.println("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
            senha = Leitura.lerTexto("\n> ");
        }

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
