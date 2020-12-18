package it.unive.dais.po1.exercise1;

/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard {
    private Mark[][] board;
    private Mark winner = null;

    public TicTacToeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = null;
            }
        }
    }

    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the cell was empty, the game was not ended (e.g., no winner yet) and
     * it filled it, false otherwise
     */
    public boolean put(Mark c, int x, int y) {
        boolean res = (this.winner != null) || (this.board[x][y] != null);

        if (res) {
            this.board[x][y] = c;
        }

        return res;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    public Mark getMark(int x, int y) {
        return this.board[x][y];
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    public Mark winner() {
        return this.winner;
    }

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        boolean shortcut = false;
        int i = 0;
        int j = 0;

        while (i < 3 && !shortcut) {
            while (j < 3 && !shortcut) {
                shortcut = this.board[i][j] == null;
                j++;
            }
            i++;
        }

        return shortcut;
    }

}
