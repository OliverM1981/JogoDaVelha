import java.util.Scanner;

/**
 * Classe principal para o Jogo da Velha.
 * Gerencia o fluxo do jogo e alterna entre os jogadores.
 */
public class JogoDaVelha {
    private final Tabuleiro tabuleiro;
    private Jogador jogadorAtual;

    /**
     * Construtor que inicializa o tabuleiro e define o jogador atual como 'X'.
     */
    public JogoDaVelha() {
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = Jogador.X;
    }

    /**
     * Inicia uma nova partida de Jogo da Velha.
     * @param scanner para leitura das jogadas do jogador
     */
    public void iniciarJogo(Scanner scanner) {
        tabuleiro.limpar();
        jogadorAtual = Jogador.X;
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            tabuleiro.exibir();
            fazerJogada(scanner);

            if (tabuleiro.verificarVitoria(jogadorAtual)) {
                tabuleiro.exibir();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                jogoAtivo = false;
            } else if (tabuleiro.verificarEmpate()) {
                tabuleiro.exibir();
                System.out.println("Empate!");
                jogoAtivo = false;
            } else {
                trocarJogador();
            }
        }
    }

    /**
     * Realiza a jogada do jogador atual.
     * @param scanner para ler a linha e a coluna da jogada
     */
    private void fazerJogada(Scanner scanner) {
        int linha, coluna;
        do {
            System.out.print("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna de 0 a 2): ");
            linha = scanner.nextInt();
            coluna = scanner.nextInt();

            if (!tabuleiro.ehJogadaValida(linha, coluna)) {
                System.out.println("Jogada inválida! Tente novamente.");
            } else {
                tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
                break;
            }
        } while (true);
    }

    /**
     * Alterna entre os jogadores X e O.
     */
    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == Jogador.X) ? Jogador.O : Jogador.X;
    }

    /**
     * Pergunta ao jogador se deseja reiniciar o jogo.
     * @param scanner para ler a resposta do jogador
     * @return true se o jogador deseja reiniciar, false caso contrário
     */
    public boolean perguntarReinicio(Scanner scanner) {
        System.out.print("Deseja jogar novamente? (s/n): ");
        return scanner.next().equalsIgnoreCase("s");
    }
}
