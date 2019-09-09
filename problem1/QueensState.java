package problem1;

import interfaces.State;

import java.util.ArrayList;

/**
 * Created by Milad on 12/19/2017.
 */
public class QueensState implements State {
    public ArrayList<Integer> board;

    public QueensState() {
        board = new ArrayList<>();
    }

}
