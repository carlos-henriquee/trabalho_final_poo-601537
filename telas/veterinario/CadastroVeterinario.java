package telas.veterinario;

import java.util.Scanner;

import db.UsuariosDB;
import usuario.Usuario;
import usuario.Veterinario;


public class CadastroVeterinario {
    public static void mostrarInterface() {
        System.out.print("\n==================================================\n");
        System.out.print("           TELA DE CADASTRO DE VETERINARIOS            ");
        System.out.print("\n==================================================\n");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu nome de usuário: ");
        String nomeDeUsuario = entrada.nextLine();


        System.out.println("Digite uma senha com no minimo 6 e no máximo 8 caracteres: ");
        System.out.print("> ");
        String senha = entrada.nextLine();
        

        try {
            Usuario veterinario = new Veterinario(nome, nomeDeUsuario, senha);
            UsuariosDB.cadastrar(veterinario);
        } catch (IllegalArgumentException e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("HOUVE UM ERRO: " + e.getMessage());
        }finally{
            entrada.close();
        }
        
        
        
    }
}
