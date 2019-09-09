# A.I. Heuristic Search Algorithms Implemented in Java 
###### Tags: Heuristic Search, Simulated Annealing, Genetic Algorithm, Hill-Climbing
###### Clean Code Status: Absolutely abstract architecture, but some refactor needed in variable names and method implementations.

It is one of my homework in the Artificial Intelligence course that we have to implement some heuristic methods for searching.

I've implemented these algorithms:

-  #### [Simulated Annealing](https://en.wikipedia.org/wiki/Simulated_annealing)

-  #### [Genetic Algorithm](https://en.wikipedia.org/wiki/Genetic_algorithm)

-  #### [Simple Hill Climbing](https://en.wikipedia.org/wiki/Hill_climbing)

-  #### [First Choice Hill Climbing]()

-  #### [Random Restart Hill Climbing](https://www.youtube.com/watch?v=lFjH05v3T54)

-  #### [Stochastic Hill Climbing]()


In order to solve a problem with these algorithms, you must first build a java class that implements interfaces/Handler.java.

This interface has three methods that must be implemented:
##### getInitial(): 
Which returns a State objects that is the initial state of a problem.


##### getNeighbour(State):
Get a state as its argument and return list of state that was the neighbour of this state for the next step.

##### stateValue(State):
Return an integer which is the value of input state to compare states with each other.


For better understanding, you should see the implementation of the 8-Queens problem which was presented in problem1/Queen.java


### How to run project:
By running Main.java, you can see the sample of solving problems with these algorithms.

Don't hesitate to ask questions if you have problems with understanding or running code.
You can find my email from my GitHub profile.
