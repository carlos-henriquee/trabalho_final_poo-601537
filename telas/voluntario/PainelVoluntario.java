package telas.voluntario;

import java.util.Scanner;

import classes_utilitarias.Leitura;
import db.AnimaisDB;

public class PainelVoluntario {
    static Scanner entrada = new Scanner(System.in);
    public static void mostrarInterface(int idVoluntario) {
        while(true){            
            System.out.print("\n==============================================\n");
            System.out.print("                ÁREA DO VOLUNTARIO");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Ver animais disponiveis para adoção\n"+
                                "2 - Ver animais sobre minha responsabilidade\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opção: ");
            int opcao = Leitura.lerNumero(entrada,"\n> ");

            while(opcao<0 || opcao>10) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero(entrada,"\n> ");
            }

        
                switch(opcao) {
                    case 0:
                        return;
                    case 1: 
                        AnimaisDB.mostrarAnimaisDisponiveisParaAdocao();
                    break;
                    case 2:
                        AnimaisDB.mostrarAnimaisDeUmVoluntario(idVoluntario);
                    break;
                    default:
                    break;
                }
            }
    }
}
