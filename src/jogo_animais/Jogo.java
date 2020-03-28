package jogo_animais;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Jogo {

	private static int tipoAnimalEscolhido;
    private static ArrayList<String> listAnimaisTerrestres = new ArrayList<>();
    private static ArrayList<String> listAnimaisAquaticos = new ArrayList<>();
    private static String[] opcao = { "SIM!!!", "Não :(" };
    private static String[] tipoAnimal = { "Aquático", "Terrestre" };
    private static int resultadoOpcaoEscolhida;

    public static void main(String[] args) {
        inicio();
    }

    private static void inicio() {
        mensagem("Pense em um animal");
        tipoAnimalEscolhido = opcaoEscolhida(tipoAnimal, "O animal que você pensou é:", "Animais");
        if (tipoAnimalEscolhido == 0) {
            checkTipoAnimalEscolhido("Peixinho", listAnimaisAquaticos);
            animais(listAnimaisAquaticos);
        } else {
            checkTipoAnimalEscolhido("Cachorro", listAnimaisTerrestres);
            animais(listAnimaisTerrestres);
        }
    }
    
    private static void checkTipoAnimalEscolhido(String animalAdd, ArrayList<String> listAnimais){
        if(listAnimais.size() == 0){
            listAnimais.add(animalAdd);
        }
    }

    private static int opcaoEscolhida(String[] opcao, String descricao, String titulo) {
        return JOptionPane.showOptionDialog(null, descricao, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, null);
    }

    private static void mensagem(String titulo) {
        JOptionPane.showMessageDialog(null, titulo);
    }

    private static void animais(ArrayList<String> listAnimais) {
        for (String animal : listAnimais) {
            final String descricao = "O animal que você pensou é um " + animal + "?";
            resultadoOpcaoEscolhida = tipoAnimalEscolhido != 0 ? opcaoEscolhida(opcao, descricao,"Animais Terrestres") : opcaoEscolhida(opcao, descricao,"Animais Aquáticos");
            if (resultadoOpcaoEscolhida == 0) {
                mensagem("Eu acerteeeei! :D");
                jogarNovamente();
                return;
            }
        }
        listAnimais.add(JOptionPane.showInputDialog("Qual animal você pensou?"));
        inicio();
    }

    private static void jogarNovamente() {
        if (opcaoEscolhida(opcao, "Quer jogar novamente?", "Reiniciar Jogo") == 0) {
            inicio();
            return;
        }
        mensagem("Tchau, até a entrevista! <3");
    }
}
