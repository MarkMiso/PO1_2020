package it.unive.dais.po1.exercise2.m880123;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

/**
 * This class represents a player of a board game
 *
 * @since 1.0
 */
public class Player extends it.unive.dais.po1.exercise2.Player {

    public Player(Mark mark) {
        super(mark);
    }

    @Override
    public boolean play(Board board) {
        int i, j, boardDimension;
        boolean cond;

        i = 0;
        cond = false;
        boardDimension = board.getDimension();
        while (i < boardDimension && !cond) {
            j = 0;
            while (j < boardDimension && !cond) {
                cond = board.putMark(super.ownMark, i, j);
                j ++;
            }

            i ++;
        }

        return cond;
    }
}
