package telas.voluntario;



import classes_utilitarias.Leitura;
import classes_utilitarias.Evento;

import usuario.Voluntario;

import db.AnimaisDB;
import db.EventosDB;
public class PainelVoluntario {
    private static void mostrarEventosDoVoluntario(Voluntario voluntario) {
        voluntario.mostrarEventosInscritos();
    }
    private static void seInscreverEvento(Voluntario voluntario) {
        EventosDB.mostrarEventos();
        if(EventosDB.quantidadeEventos>0) {
            System.out.println("Digite o id do evento que deseja se inscrever");
            int idEvento = Leitura.lerNumero("\n> ");
            Evento eventoSelecionado = EventosDB.validarEventoPorId(idEvento); 
            if(eventoSelecionado==null) {
                System.out.println("EVENTO NAO EXISTE!");
                return;
            }else{
                eventoSelecionado.inscreverVoluntario(voluntario);
            }
        }
        
    }
    private static void mostrarAnimaisDeUmVoluntario(Voluntario voluntario) {
        voluntario.mostrarMeusAnimais();
    }
    public static void mostrarInterface(Voluntario voluntario) {
        while(true){            
            System.out.print("\n==============================================\n");
            System.out.print("                ÁREA DO VOLUNTARIO");
            System.out.print("\n==============================================\n");
            System.out.println( "1 - Ver animais disponiveis para adoção\n"+
                                "2 - Ver animais sobre minha responsabilidade\n" +
                                "3 - Ver meus eventos\n"+
                                "4 - Inscrever-se em um evento\n" +
                                "0 - Sair"
                            );
            System.out.println("Escolha uma opção: ");
            int opcao = Leitura.lerNumero("\n> ");

            while(opcao<0 || opcao>10) {
                System.out.println("Opção inválida! Digite novamente!");
                opcao = Leitura.lerNumero("\n> ");
            }

        
                switch(opcao) {
                    case 0:
                        return;
                    case 1: 
                        AnimaisDB.mostrarAnimaisDisponiveisParaAdocao();
                    break;
                    case 2:
                        mostrarAnimaisDeUmVoluntario(voluntario);
                    break;

                    case 3:
                        mostrarEventosDoVoluntario(voluntario);
                    break;

                    case 4:
                        seInscreverEvento(voluntario);
                    break;

                    default:
                    break;
                }
            }
    }
}
