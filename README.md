PuzzleSolver
============
This is a final project from a object oriented programming class I took at RIT. Each puzzle can be solved by using 
the generic breadth first search implementation called Solver. They are listed below in increasing complexity. All 
are run from the command line but Chess has a GUI interface that allows the user to play the game as well as solicit
help from the solver.

Clock
============
The first puzzle is a clock. The clock only has an hour hand, where N is the number of hours, which can be turned 
forward or backward one hour at a time (called a step). There are three parameters associated with the clock:

    The number of hours, an integer N
    The start time, an integer from 1..N
    The goal time, an integer from 1..N

The program is run from the command line as:

    %  java Clock {hours} {start} {goal}

The program displays, to standard output, the shortest number of steps it takes to get from the start to the goal
time. For example:

    % java Clock 15 2 14
    Step 0:  2
    Step 1:  1
    Step 2:  15
    Step 3:  14

Water
============
The water puzzle poses the following problem. Assume you are at a lake and have a collection of empty jugs that can
each hold different amounts of water. The goal is to get a desired amount of water in any one of the jugs using the
shortest number of steps. A single step consists of one of the following actions:

    Fill a single jug up to complete capacity by submerging it in the lake.
    Empty a single jug by dumping all water in the jug into the lake.
    Pour the contents of any one jug into another jug, without exceeding the capacity of the jug being poured into.
This puzzle was made famous in a scene of the third Die Hard movie.

The program is run from the command line as:

    %   java Water {amount} {jug1} [{jug2} ...]
    
The program must run with a minimum of two arguments:

    The desired amount of water, a positive integer
    The capacity of the first jug, a positive integer
    
If any additional arguments are specified, they will be capacities for the remaining jugs. Unlike the example above,
there is no limit to the number of jugs that may be specified. Sample ouput:

    % java Water 4 5 3
    Step 0:  0 0
    Step 1:  5 0
    Step 2:  2 3
    Step 3:  2 0
    Step 4:  0 2
    Step 5:  5 2
    Step 6:  4 3

Chess
============
Chess is a GUI implementation of the game Solitaire Chess. It takes in a text file with formatting like 
chessInitialSetup.txt to define initial board layout. The user can play the game to its conclusions without any input
from the solver. However, at any point in the game the user can ask for the best next move which is found using the
Solver.
