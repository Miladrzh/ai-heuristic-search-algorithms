package algorithms;

import interfaces.Handler;
import interfaces.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Milad on 12/21/2017.
 */
public class FirstChoiceHillClimbing {
    Handler handler;
    int totalSeen;
    int totalExpand;

    public int getTotalExpand() {
        return totalExpand;
    }

    public int getTotalSeen() {
        return totalSeen;
    }

    public FirstChoiceHillClimbing(Handler x) {
        this.handler = x;
    }

    public State search() {
        State now = handler.getIntial();
        boolean haveBetter = true;
        ArrayList<State> nexts = new ArrayList<>();
        while (haveBetter) {
            totalExpand++;
            ArrayList<State> neighbours = handler.getNeighbour(now);
            long seed = System.nanoTime();
            Collections.shuffle(neighbours, new Random(seed));
            State nextExpand = null;
            for (State i : neighbours) {
                totalSeen++;
                if (handler.stateValue(i) > handler.stateValue(now)) {
                    nextExpand = i;
                    break;
                }
            }
            if (nextExpand == null)
                haveBetter = false;
            else {
                now = nextExpand;
            }
        }
        return now;
    }
}
