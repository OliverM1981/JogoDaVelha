/**
 * Representa o tabuleiro do jogo e contém métodos para manipulação.
 */
public class Tabuleiro {
    private final char[][] tabuleiro;

    /**
     * Construtor que inicializa o tabuleiro com tamanho 3x3.
     */
    public Tabuleiro() {
        this.tabuleiro = new char[3][3];
    }

    /**
     * Limpa o tabuleiro, definindo todas as células como '-'.
     */
    public void limpar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    /**
     * Exibe o estado atual do tabuleiro.
     */
    public void exibir() {
        System.out.println("Tabuleiro:");
        for (char[] linha : tabuleiro) {
            for (char celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }

    /**
     * Verifica se uma jogada é válida.
     * @param linha linha da jogada
     * @param coluna coluna da jogada
     * @return true se a jogada é válida, false caso contrário
     */
    public boolean ehJogadaValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == '-';
    }

    /**
     * Realiza uma jogada no tabuleiro.
     * @param linha linha da jogada
     * @param coluna coluna da jogada
     * @param jogador jogador que está fazendo a jogada
     */
    public void fazerJogada(int linha, int coluna, Jogador jogador) {
        tabuleiro[linha][coluna] = jogador.getSimbolo();
    }

    /**
     * Verifica se o jogador atual venceu o jogo.
     * @param jogador o jogador a ser verificado
     * @return true se o jogador venceu, false caso contrário
     */
    public boolean verificarVitoria(Jogador jogador) {
        char simbolo = jogador.getSimbolo();
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) {
                return true;
            }
        }
        return (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) ||
               (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo);
    }

    /**
     * Verifica se há empate no jogo.
     * @return true se o jogo está empatado, false caso contrário
     */
    public boolean verificarEmpate() {
        for (char[] linha : tabuleiro) {
            for (char celula : linha) {
                if (celula == '-') return false;
            }
        }
        return true;
    }
}
