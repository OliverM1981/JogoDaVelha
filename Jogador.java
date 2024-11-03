/**
 * Enum para representar os jogadores do jogo.
 */
public enum Jogador {
    X('X'), O('O');

    private final char simbolo;

    /**
     * Construtor para definir o símbolo do jogador.
     * @param simbolo símbolo do jogador ('X' ou 'O')
     */
    Jogador(char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Retorna o símbolo do jogador.
     * @return o símbolo do jogador
     */
    public char getSimbolo() {
        return simbolo;
    }
}

