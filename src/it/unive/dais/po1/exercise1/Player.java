package it.unive.dais.po1.exercise1;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
public class Player {
    private Mark mark;

    /**
     * Intializes a player using the given Mark
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    /**
     * Plays a round of the game.
     *
     * @param board
     * @return true if the player was able to
     */
    public boolean play(TicTacToeBoard board) {
        int i = 0;
        int j = 0;
        boolean cond = false;

        while (i < 3 && !cond) {
            while (j < 3 && !cond) {
                cond = board.getMark(i, j) == null;
                j++;
            }
            i++;
        }

        return board.put(mark, i - 1, j - 1);
    }
}
