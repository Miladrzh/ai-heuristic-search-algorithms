package problem2;

import interfaces.State;

/**
 * Created by Milad on 12/21/2017.
 */
public class GraphState implements State {
    public int[] level;

    public GraphState() {
        level = new int[13];
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 1; i <= 12; i++) {
            ret += (i + " : ");
            if (level[i] == 1) ret += "up\n";
            else ret += "down\n";
        }
        return ret;
    }
}
