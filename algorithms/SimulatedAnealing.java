package algorithms;

import interfaces.Handler;
import interfaces.State;
import problem2.Graph;
import problem2.GraphState;

import java.util.ArrayList;

/**
 * Created by Milad on 12/21/2017.
 */
public class SimulatedAnealing {
    public double currentTemprature, coolRate;
    public Handler handler;
    int totalSeen;
    int totalExpand;

    public SimulatedAnealing(double currentTemprature, double diffTemprature, Handler handler) {
        this.handler = handler;
        this.currentTemprature = currentTemprature;
        this.coolRate = diffTemprature;
    }

    public int getTotalExpand() {
        return totalExpand;
    }

    public int getTotalSeen() {
        return totalSeen;
    }

    public State search() {
        State now = handler.getIntial();

        while (currentTemprature > 0.001) {
            totalExpand++;
            ArrayList<State> neighbours = handler.getNeighbour(now);
            State nextExpand = neighbours.get((int) (Math.random() * 12));
            if (handler.stateValue(nextExpand) > handler.stateValue(now)) {
                now = nextExpand;
            } else {
                double changer = Math.random();
                if (changer < currentTemprature) {
                    now = nextExpand;
                    totalSeen++;
                }
            }
            currentTemprature *= (1.0 - coolRate);
        }
        return now;
    }

}
