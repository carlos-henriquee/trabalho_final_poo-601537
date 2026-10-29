package telas;

import java.util.*;

import db.AnimaisDB;
import telas.cad_log.TelaCadastroGenerico;
import telas.cad_log.TelaLogin;
public class Menu {
    public static void mostrarInterface() {
        while(true) {
            System.out.print("\n==============================================\n");
            System.out.print("                MENU PRINCIPAL");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Fazer Login\n"+
                                "2 - Realizar Cadastro\n"+
                                "3 - Visualizar Animais Disponíveis\n"+
                                "4 - Sobre o Sistema\n"+
                                "0 - Encerrar o Programa"
                            );
            
            System.out.println("\nEscolha uma opção :");
            Scanner input = new Scanner(System.in);
            System.out.print("> ");
            int opcao = input.nextInt();
            while(opcao<0||opcao>4) {
                System.out.println("Opcao invalida! Tente novamente: ");
                System.out.print("> ");
                opcao = input.nextInt();
            }

            switch (opcao) {
                case 0:
                    return;
                case 1:
                    TelaLogin.mostrarInterface();
                break;
                
                case 2:
                    TelaCadastroGenerico.mostrarInterface();
                break;
                case 3:
                    AnimaisDB.mostrarAnimais();
                break;
                case 4:
                    System.out.println("=============================================");
                    System.out.println("               SOBRE O SISTEMA");
                    System.out.println("=============================================");
                    System.out.println("Esse é um sistema de adoção de animais desenvolvido\n"+
                                        "pelo estudante Carlos Henrique Oliveira Sales, aluno\n"+
                                        "do curso de Ciência da Computação na UFC, campus de\n" + 
                                        "Crateús, pela matrícula 601537. O sistema conta com\n"+
                                        "mecanismos de login/cadastro de voluntarios e veterinarios\n"+
                                        "com varias funcionalidades para cada cargo. Além disso,\n"+
                                        "inclui um sistema de notificações em tempo real."
                    );
                break;
                default:
                    break;
            }
            
        }
        }
        
}