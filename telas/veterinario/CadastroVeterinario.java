package telas.veterinario;

import classes_utilitarias.Leitura;
import db.UsuariosDB;
import usuario.Usuario;
import usuario.Veterinario;


public class CadastroVeterinario {
    public static void mostrarInterface() {
        System.out.print("\n==================================================\n");
        System.out.print("           TELA DE CADASTRO DE VETERINARIOS            ");
        System.out.print("\n==================================================\n");
        
        String nome = Leitura.lerTexto("Digite seu nome: ");

        String nomeDeUsuario = Leitura.lerTexto("Digite seu nome de usuario: ");
        Usuario jaExiste = UsuariosDB.validarUsuarioPorNomeDeUsuario(nomeDeUsuario);
        if(jaExiste!=null) {
            System.out.println("JA EXISTE UM USUARIO COM ESSE USERNAME");
            return;
        }


        System.out.print("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
        String senha = Leitura.lerTexto("\n> ");
        

        try {
            Usuario veterinario = new Veterinario(nome, nomeDeUsuario, senha);
            UsuariosDB.cadastrar(veterinario);
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        }
        
        
    }
}
