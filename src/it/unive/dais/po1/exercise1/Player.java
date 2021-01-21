package it.unive.dais.po1.exercise1;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
public class Player {
    private Mark mark;

    /**
     * Initializes a player using the given Mark
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    /**
     * Plays a round of the game.
     * @param board TicTacToe board
     * @return true if the player was able to
     */
    public boolean play(TicTacToeBoard board) {
        int i, j;
        boolean cond = false;

        i = 0;
        j = 0;
        while (i < 3 && !cond) {
            j = 0;
            while (j < 3 && !cond) {
                cond = board.getMark(i, j) == null;
                j++;
            }
            i++;
        }

        return board.put(this.mark, i - 1, j - 1);
    }
}
