package algorithms;

import interfaces.Handler;
import interfaces.State;
import problem3.EquationState;

import java.util.ArrayList;

/**
 * Created by Milad on 12/21/2017.
 */
public class GeneticAlgorithm {
    Handler handler;
    int totalSeen;
    int totalExpand;
    double mutationRate;
    int maxPopulation, maxGeneration;
    ArrayList<Integer> maxVal, avgVal, minVal;

    public GeneticAlgorithm(double mutationRate, int maxPopulation, int maxGeneration, Handler handler) {
        this.handler = handler;
        this.mutationRate = mutationRate;
        this.maxPopulation = maxPopulation;
        this.maxGeneration = maxGeneration;
        maxVal = new ArrayList<>();
        minVal = new ArrayList<>();
        avgVal = new ArrayList<>();
    }

    public int getTotalExpand() {
        return totalExpand;
    }

    public int getTotalSeen() {
        return totalSeen;
    }

    public State search() {
        ArrayList<State> currentPopulation = new ArrayList<>();

        while (currentPopulation.size() < maxPopulation) {
            currentPopulation.add(handler.getRandomIntial());
        }

        int generationCount = 1;

        while (generationCount < maxGeneration) {

            int maxi = 1;
            int sum = 0;
            for (State i : currentPopulation) {
                EquationState tmp = (EquationState) i;
                sum += handler.stateValue(i);
                if (maxi < handler.stateValue(i)) {
                    maxi = handler.stateValue(i);
                }
            }
            maxVal.add(maxi);
            avgVal.add(sum / currentPopulation.size());
            int mini = 2000;
            for (State i : currentPopulation) {
                EquationState tmp = (EquationState) i;
                if (mini > handler.stateValue(i)) {
                    mini = handler.stateValue(i);
                }
            }
            minVal.add(mini);

            // bache sakhtan o jahesh
            ArrayList<State> nextGen = new ArrayList<>();
            for (int i1 = 0; i1 < currentPopulation.size(); i1++) {
                for (int j1 = 0; j1 < currentPopulation.size(); j1++) {
                    State i = currentPopulation.get(i1);
                    State j = currentPopulation.get(j1);

                    EquationState tmp1 = (EquationState) i;
                    EquationState tmp2 = (EquationState) j;
                    double prob = (double) handler.stateValue(i) / (double) maxi + (double) handler.stateValue(j) / (double) maxi;
                    if (Math.random() < prob) {
                        if (Math.random() < mutationRate) {
                            nextGen.add((tmp1.child(tmp2).mutate()));
                        } else {
                            nextGen.add(tmp1.child(tmp2));
                        }
                    }
                }
            }
            for (State i : nextGen)
                currentPopulation.add(i);

            generationCount++;

            // hazf ezafi ha bara nasle bad
            maxi = 1;
            for (State i : currentPopulation) {
                EquationState tmp = (EquationState) i;
                if (maxi < handler.stateValue(i)) {
                    maxi = handler.stateValue(i);
                }
            }
            int cnt = 0;
            while (currentPopulation.size() > maxPopulation) {
                cnt++;
                for (int i = 0; i < currentPopulation.size() && currentPopulation.size() > maxPopulation; i++) {
                    EquationState tmp = (EquationState) currentPopulation.get(i);
                    double tk = Math.random();

                    if (tk > (double) handler.stateValue(tmp) / (double) maxi)
                        currentPopulation.remove(i);
                }
                if (cnt >= 20)
                    while (currentPopulation.size() > maxPopulation)
                        currentPopulation.remove(0);
            }
        }

        State ret = new EquationState();
        int maxi = handler.stateValue(ret);
        for (State i : currentPopulation) {
            EquationState tmp = (EquationState) i;
            if (maxi < handler.stateValue(i)) {
                maxi = handler.stateValue(i);
                ret = i;
            }
        }
        return ret;
    }

    public ArrayList<Integer> getMax() {
        return maxVal;
    }

    public ArrayList<Integer> getAvg() {
        return avgVal;
    }

    public ArrayList<Integer> getMin() {
        return minVal;
    }
}
