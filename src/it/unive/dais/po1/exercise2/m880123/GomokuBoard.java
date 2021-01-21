package it.unive.dais.po1.exercise2.m880123;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

/**
 * This class represents a gomoku board
 *
 * @since 1.0
 */
public class GomokuBoard extends Board {

    public GomokuBoard(int dimension) {
        super(dimension);
    }

    /**
     * Returns if the Mark in a cell is a winner
     * @param x x coordinate
     * @param y y coordinate
     * @return true if the Mark is a winner, else false
     */
    private boolean isWinner(int x, int y) {
        int i, j;
        boolean cond1, cond2, cond3, cond4;

        i = 0;
        j = 4;
        cond1 = true;
        cond2 = true;
        cond3 = true;
        cond4 = true;
        while ((cond1 || cond2 || cond3 || cond4) && (i < 4)) {
            cond1 = cond1 && ((getMark(x + i, y + i) != null) && (getMark(x + i, y + i) == getMark(x + i + 1, y + i + 1)));
            cond2 = cond2 && ((getMark(x + i, y - i) != null) && (getMark(x + i, y - i) == getMark(x + i + 1, y - i - 1)));
            cond3 = cond3 && ((getMark(x + i, y) != null) && (getMark(x + i, y) == getMark(x + i + 1, y)));
            cond4 = cond4 && ((getMark(x, y + i) != null) && (getMark(x, y + i) == getMark(x, y + i + 1)));
            i++;
            j--;
        }

        return cond1 || cond2 || cond3 || cond4;
    }

    @Override
    public Mark winner() {
        int i, j;
        int tableDim = super.getDimension();
        boolean cond = false;

        i = 0;
        j = 0;
        while (!cond && (i < tableDim)) {
            j = 0;
            while (!cond && (j < tableDim)) {
                cond = isWinner(i, j);
                j++;
            }

            i++;
        }

        if (cond) {
            return getMark(i - 1, j - 1);
        } else {
            return null;
        }
    }
}
