package problem3;

import interfaces.Handler;
import interfaces.State;

import java.util.ArrayList;

/**
 * Created by Milad on 12/21/2017.
 */
public class Equation implements Handler {
    public Equation() {
    }

    @Override
    public int stateValue(State x) {
        EquationState state = (EquationState) x;
        return 100 - Math.abs((40 - state.value()));
    }

    @Override
    public State getRandomIntial() {
        return new EquationState();
    }

    @Override
    public State getIntial() {
        return null;
    }

    @Override
    public ArrayList<State> getNeighbour(State now) {
        return null;
    }
}
