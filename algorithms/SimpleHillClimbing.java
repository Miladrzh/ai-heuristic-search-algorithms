package algorithms;

import interfaces.Handler;
import interfaces.State;
import problem1.Queens;
import problem1.QueensState;

import java.util.ArrayList;

/**
 * Created by Milad on 12/19/2017.
 */
public class SimpleHillClimbing {
    Handler handler;
    int totalSeen;
    int totalExpand;

    public int getTotalExpand() {
        return totalExpand;
    }

    public int getTotalSeen() {
        return totalSeen;
    }

    public SimpleHillClimbing(Handler x) {
        this.handler = x;
    }

    public State search() {
        State now = handler.getIntial();
        boolean haveBetter = true;
        while (haveBetter) {
            totalExpand++;
            ArrayList<State> neighbours = handler.getNeighbour(now);
            State nextExpand = null;
            for (State i : neighbours) {
                totalSeen++;
                if (handler.stateValue(i) > handler.stateValue(now) && (nextExpand == null || handler.stateValue(i) > handler.stateValue(nextExpand))) {
                    nextExpand = i;
                }
            }
            if (nextExpand == null)
                haveBetter = false;
            else
                now = nextExpand;
        }
        return now;
    }
}
