import java.util.Scanner;

/**
 * Classe Main para iniciar o Jogo da Velha.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            JogoDaVelha jogo = new JogoDaVelha();
            do {
                jogo.iniciarJogo(scanner);
            } while (jogo.perguntarReinicio(scanner));
        }
    }
}
