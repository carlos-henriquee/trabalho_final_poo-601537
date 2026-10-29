package classes_utilitarias;
import java.util.Scanner;

public class Leitura {
    public static int lerNumero(Scanner scanner, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e){
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("HOUVE UM ERRO: " + e.getMessage());
            }
        }
    }
}
