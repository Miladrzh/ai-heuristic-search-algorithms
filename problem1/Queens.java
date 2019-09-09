package problem1;

import interfaces.Handler;
import interfaces.State;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Milad on 12/19/2017.
 */
public class Queens implements Handler {
    public Queens() {

    }

    public State getIntial() {
        QueensState ret = new QueensState();
        for (int i = 0; i < 8; i++)
            ret.board.add(1);
        return ret;
    }

    public State getRandomIntial() {
        QueensState ret = new QueensState();
        for (int i = 0; i < 8; i++)
            ret.board.add((int) (Math.random() * 8 + 1));
        return ret;
    }

    public ArrayList<State> getNeighbour(State state) {
        QueensState x = (QueensState) state;
        ArrayList<State> ret = new ArrayList<>();
        for (int i = 0; i < x.board.size(); i++) {
            for (int j = 1; j <= 8; j++) {
                QueensState tmp = new QueensState();
                for (int k = 0; k < x.board.size(); k++)
                    tmp.board.add(x.board.get(k));

                if (j != x.board.indexOf(i)) {
                    tmp.board.remove(i);
                    tmp.board.add(i, j);
                }
                ret.add(tmp);
            }
        }
        return ret;
    }

    public int stateValue(State state) {
        QueensState x = (QueensState) state;
        int ret = 0;
        for (int i = 0; i < x.board.size(); i++) {
            for (int j = 0; j < x.board.size(); j++) {
                if (i != j && x.board.get(i) == x.board.get(j))
                    ret++;
            }
        }
        for (int i = 0; i < x.board.size(); i++) {
            int xCor = i + 1;
            int yCor = x.board.get(i);

            int xCorMem = xCor, yCorMem = yCor;

            // +1 +1
            while (++xCorMem < 9 && ++yCorMem < 9) {
                if (x.board.get(xCorMem - 1) == yCorMem)
                    ret++;
            }

            // +1 -1
            xCorMem = xCor;
            yCorMem = yCor;
            while (++xCorMem < 9 && --yCorMem > 0) {
                if (x.board.get(xCorMem - 1) == yCorMem)
                    ret++;
            }

            // -1 +1
            xCorMem = xCor;
            yCorMem = yCor;
            while (--xCorMem > 0 && ++yCorMem < 9) {
                if (x.board.get(xCorMem - 1) == yCorMem)
                    ret++;
            }

            // -1 -1
            xCorMem = xCor;
            yCorMem = yCor;
            while (--xCorMem > 0 && --yCorMem > 0) {
                if (x.board.get(xCorMem - 1) == yCorMem)
                    ret++;
            }
        }
        return (28 - ret / 2);
    }
}
