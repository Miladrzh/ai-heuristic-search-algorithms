package interfaces;

import java.util.ArrayList;

/**
 * Created by Milad on 12/19/2017.
 */
public interface Handler {
    int stateValue(State x);

    State getIntial();

    State getRandomIntial();

    ArrayList<State> getNeighbour(State now);

}
