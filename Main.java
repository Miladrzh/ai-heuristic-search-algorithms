import algorithms.*;
import problem1.Queens;
import problem1.QueensState;
import problem2.Graph;
import problem2.GraphState;
import problem3.Equation;
import problem3.EquationState;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Milad on 12/19/2017.
 */
public class Main {
    public static void main(String[] args) {


        ///////////////////////////////
        Scanner inp = new Scanner(System.in);
        System.out.println("Which Problem you wanna test?! Enter number of choice");
        System.out.println("1- problem1 8Queen  2- problem2 Graph  3- problem3 Genetic");
        int choice = inp.nextInt();
        if (choice == 1) {
            Queens queens = new Queens();
            System.out.println("Which hill climbing you wanna use?");
            System.out.println("1- simple       2- Random Restart       3- Stochastic    4-FirstChoice");
            int algoChoice = inp.nextInt();
            if (algoChoice == 1) {
                SimpleHillClimbing simpleHillClimbing = new SimpleHillClimbing(queens);
                QueensState answer = (QueensState) simpleHillClimbing.search();
                System.out.println("The answer is :");
                for (int i = 0; i < answer.board.size(); i++) {
                    System.out.println("( " + (i + 1) + " , " + answer.board.get(i) + " )");
                }
                System.out.println("The value of answer is : " + queens.stateValue(answer));
                System.out.println("Total seen state is : " + simpleHillClimbing.getTotalSeen());
                System.out.println("Total Expand state is : " + simpleHillClimbing.getTotalExpand());
            } else if (algoChoice == 2) {
                RandomRestartHillClimbing randomRestartHillClimbing = new RandomRestartHillClimbing(queens);
                QueensState answer = (QueensState) randomRestartHillClimbing.search();
                System.out.println("The answer is :");
                for (int i = 0; i < answer.board.size(); i++) {
                    System.out.println("( " + (i + 1) + " , " + answer.board.get(i) + " )");
                }
                System.out.println("The value of answer is : " + queens.stateValue(answer));
                System.out.println("Total seen state is : " + randomRestartHillClimbing.getTotalSeen());
                System.out.println("Total Expand state is : " + randomRestartHillClimbing.getTotalExpand());
            } else if (algoChoice == 3) {
                StochasticHillClimbing stochasticHillClimbing = new StochasticHillClimbing(queens);
                QueensState answer = (QueensState) stochasticHillClimbing.search();
                System.out.println("The answer is :");
                for (int i = 0; i < answer.board.size(); i++) {
                    System.out.println("( " + (i + 1) + " , " + answer.board.get(i) + " )");
                }
                System.out.println("The value of answer is : " + queens.stateValue(answer));
                System.out.println("Total seen state is : " + stochasticHillClimbing.getTotalSeen());
                System.out.println("Total Expand state is : " + stochasticHillClimbing.getTotalExpand());
            } else if (algoChoice == 4) {
                FirstChoiceHillClimbing firstChoiceHillClimbing = new FirstChoiceHillClimbing(queens);
                QueensState answer = (QueensState) firstChoiceHillClimbing.search();
                System.out.println("The answer is :");
                for (int i = 0; i < answer.board.size(); i++) {
                    System.out.println("( " + (i + 1) + " , " + answer.board.get(i) + " )");
                }
                System.out.println("The value of answer is : " + queens.stateValue(answer));
                System.out.println("Total seen state is : " + firstChoiceHillClimbing.getTotalSeen());
                System.out.println("Total Expand state is : " + firstChoiceHillClimbing.getTotalExpand());
            }
        } else if (choice == 2) {
            System.out.println("You choose problem 2. Please Enter the Initial Temprature between 0 , 1");
            double initialTemp, coolingRate;
            initialTemp = inp.nextDouble();
            System.out.println("now enter the CoolingRate between 0 , 1");
            coolingRate = inp.nextDouble();
            Graph graph = new Graph();
            SimulatedAnealing simulatedAnealing = new SimulatedAnealing(initialTemp, coolingRate, graph);
            GraphState answer = (GraphState) simulatedAnealing.search();
            System.out.println("the finding answer is: ");
            System.out.println(answer);
            System.out.println("The value of answer is : " + graph.stateValue(answer));
            System.out.println("Total seen state is : " + simulatedAnealing.getTotalSeen());
            System.out.println("Total Expand state is : " + simulatedAnealing.getTotalExpand());
        } else if (choice == 3) {
            double mutationRate;
            int maxPopulation, maxGeneration;
            System.out.println("You choose problem 2. Please Enter the mutation Rate between 0 , 1");
            mutationRate = inp.nextDouble();
            System.out.println("Please Enter the maxPopulation");
            maxPopulation = inp.nextInt();
            System.out.println("Please Enter the maxGeneration Count");
            maxGeneration = inp.nextInt();
            Equation equation = new Equation();
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(mutationRate, maxPopulation, maxGeneration, equation);
            EquationState answer = (EquationState) geneticAlgorithm.search();
            System.out.println("answer is :");
            System.out.println(answer);
            System.out.println("the result of equation is: " + answer.value());
            System.out.println("the answer value is: " + equation.stateValue(answer));
            ArrayList<Integer> avg = geneticAlgorithm.getAvg();
            ArrayList<Integer> maxVal = geneticAlgorithm.getMax();
            ArrayList<Integer> minVal = geneticAlgorithm.getMin();

            System.out.println("the average value in generation is: ");

            System.out.flush();
            for (int i = 0; i < maxGeneration - 1; i++)
                System.out.println((i + 1) + " : " + avg.get(i));
            System.out.println("the max value in generation is: ");
            for (int i = 0; i < maxGeneration - 1; i++)
                System.out.println((i + 1) + " : " + maxVal.get(i));
            System.out.println("the min value in generation is: ");
            for (int i = 0; i < maxGeneration - 1; i++)
                System.out.println((i + 1) + " : " + minVal.get(i));

        } else {
            System.out.println("your choice is incorrect");
        }
    }
}
