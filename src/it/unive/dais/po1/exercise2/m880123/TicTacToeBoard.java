package it.unive.dais.po1.exercise2.m880123;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard extends Board {

    /**
     * Creates a 3x3 square board
     */
    public TicTacToeBoard() {
        super(3);
    }

    @Override
    public Mark winner() {
        Mark winner = null;
        boolean cond = false;

        if ((getMark(0,0) != null) && ((getMark(0, 0) == getMark(1, 1)) && (getMark(1,1) == getMark(2,2)))) {
            winner = getMark(1,1);
            cond = true;
        }

        if ((!cond && getMark(0,2) != null) && ((getMark(0, 2) == getMark(1, 1)) && (getMark(1,1) == getMark(2,0)))) {
            winner = getMark(1,1);
            cond = true;
        }

        int i = 0;
        while (i < 3 && !cond) {
            cond = (getMark(i,0) != null) && ((getMark(i, 0) == getMark(i, 1)) && (getMark(i,1) == getMark(i,2)));
            if (cond) {
                winner = getMark(i, 1);
            } else {
                cond = (getMark(0, i) != null) && ((getMark(0, i) == getMark(1, i)) && (getMark(1, i) == getMark(2, i)));
                if (cond) { winner = getMark(1, i); }
            }

            i++;
        }

        return winner;
    }
}
