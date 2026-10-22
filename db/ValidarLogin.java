package db;

public class ValidarLogin {
    public static boolean validar(String user, String senha) {
        //FALTA O DE VETERINARIOOOOOOOOOOOO!
        if(Voluntarios.validarVoluntario(user, senha)){
            return true;
        }else {
            return false;
        }
        
    }
}
