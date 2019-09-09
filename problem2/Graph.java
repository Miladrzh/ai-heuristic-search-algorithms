package problem2;

import interfaces.Handler;
import interfaces.State;

import java.util.ArrayList;

/**
 * Created by Milad on 12/21/2017.
 */
public class Graph implements Handler {
    @Override
    public int stateValue(State x) {
        GraphState state = (GraphState) x;
        int ret = 0;
        int down = 0;
        for (int i = 1; i <= 12; i++) {
            if (state.level[i] == 0) {
                down++;
            }
        }
        ret += Math.max(down * 10, (12 - down) * 10);

        // check kardan hamsayegi
        if (state.level[1] != state.level[2])
            ret++;
        if (state.level[1] != state.level[3])
            ret++;
        if (state.level[2] != state.level[3])
            ret++;
        if (state.level[2] != state.level[4])
            ret++;
        if (state.level[3] != state.level[5])
            ret++;
        if (state.level[3] != state.level[6])
            ret++;
        if (state.level[4] != state.level[5])
            ret++;
        if (state.level[4] != state.level[7])
            ret++;
        if (state.level[5] != state.level[8])
            ret++;
        if (state.level[6] != state.level[9])
            ret++;
        if (state.level[7] != state.level[8])
            ret++;
        if (state.level[8] != state.level[9])
            ret++;
        if (state.level[8] != state.level[10])
            ret++;
        if (state.level[9] != state.level[11])
            ret++;
        if (state.level[9] != state.level[12])
            ret++;
        if (state.level[10] != state.level[12])
            ret++;
        if (state.level[11] != state.level[12])
            ret++;

        return 120 - ret;
    }

    @Override
    public State getIntial() {
        return (State) new GraphState();
    }

    @Override
    public State getRandomIntial() {
        return null;
    }

    @Override
    public ArrayList<State> getNeighbour(State now) {
        ArrayList<State> nei = new ArrayList<>();
        GraphState x = (GraphState) now;
        for (int i = 1; i <= 12; i++) {
            GraphState tmp = new GraphState();
            for (int j = 1; j <= 12; j++) {
                tmp.level[j] = x.level[j];
            }
            tmp.level[i] = 1 - x.level[i];
            nei.add((State) tmp);
        }
        return nei;
    }
}
