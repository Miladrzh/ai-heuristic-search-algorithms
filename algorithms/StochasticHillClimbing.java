package algorithms;

import interfaces.Handler;
import interfaces.State;

import java.util.ArrayList;

/**
 * Created by Milad on 12/19/2017.
 */
public class StochasticHillClimbing {
    Handler handler;
    int totalSeen;
    int totalExpand;

    public int getTotalExpand() {
        return totalExpand;
    }

    public int getTotalSeen() {
        return totalSeen;
    }

    public StochasticHillClimbing(Handler x) {
        this.handler = x;
    }

    public State search() {
        State now = handler.getIntial();
        boolean haveBetter = true;
        ArrayList<State> nexts = new ArrayList<>();
        while (haveBetter) {
            totalExpand++;
            ArrayList<State> neighbours = handler.getNeighbour(now);
            State nextExpand = null;
            for (State i : neighbours) {
                totalSeen++;
                if (handler.stateValue(i) > handler.stateValue(now)) {
                    nextExpand = i;
                    nexts.add(i);
                }
            }
            if (nextExpand == null)
                haveBetter = false;
            else {
                now = nexts.get((int) (Math.random() * nexts.size()));
            }
        }
        return now;
    }
}
