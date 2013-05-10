package puzzleSolver;

import java.util.ArrayList;

/**
 *
 *File:
 *	$Id: Clock.java,v 1.5 2013/05/01 11:46:15 cas5420 Exp $
 *
 *Revisions
 *	$Log: Clock.java,v $
 *	Revision 1.5  2013/05/01 11:46:15  cas5420
 *	Updated solver to generics
 *
 *	Revision 1.4  2013/04/27 13:00:58  cas5420
 *	Started project
 *
 *	Revision 1.6  2013/04/14 20:50:52  mgp9795
 *	Part 2 Adjustments
 *
 *	Revision 1.5  2013/04/01 20:04:20  mgp9795
 *	*** empty log message ***
 *
 *	Revision 1.4  2013/04/01 20:02:46  mgp9795
 *	*** empty log message ***
 *
 *	Revision 1.3  2013/04/01 20:01:40  mgp9795
 *	*** empty log message ***
 *
 *	Revision 1.2  2013/04/01 19:58:28  mgp9795
 *	Arg Length Check
 *
 *	Revision 1.1  2013/04/01 19:41:43  mgp9795
 *	Initial Version
 *
 */

/**
 * 
 * @author Michael
 * @author Chris Sleys
 * 
 */
public class Clock implements Puzzle<Integer> {
	private int numHours; // the number of hours on the clock
	private int startTime; // the starting time for the puzzle
	private int goalTime; // the time we are attempting to reach

	/**
	 * main method for program
	 * 
	 * @param args
	 *            - holds values for private fields
	 */
	public static void main(String[] args) {
		ArrayList<Integer> solution;
		if (args.length == 3) {
			solution = new Solver<Integer>().solve(new Clock(Integer.parseInt(args[0]),
					Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			if (solution != null) {
				for (int i = 0; i < solution.size(); i++) {
					System.out.println("Step " + i + ": "
							+ solution.get(i));
				}
			} else {
				System.out.println("Step 0: " + Integer.parseInt(args[1]));
			}
		} else {
			System.out.println("Usage: java Clock hours start goal");
		}
	}

	/**
	 * Constructor, sets initial field values
	 * 
	 * @param numHours
	 *            - the number of hours on the clock
	 * @param startTime
	 *            - the starting time for the puzzle
	 * @param goalTime
	 *            - the time we are attempting to reach
	 */
	public Clock(int numHours, int startTime, int goalTime) {
		this.numHours = numHours;
		this.startTime = startTime;
		this.goalTime = goalTime;
	}

	/**
	 * Returns the goal configurating
	 * 
	 * @return Integer representing goal time.
	 */
	public boolean isGoal(Integer config) {
		if (this.goalTime == config) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returns an ArrayList of neighbors to parameter
	 * 
	 * @param config
	 *            - current puzzle configuration
	 * @return ArrayList<ArrayList<Integer>> neighbors
	 */
	public ArrayList<Integer> getNeighbors(Integer config) {
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		Integer sub1, sub2;
		
		if (config > 1 && config < numHours) {
			sub1 = config - 1;
			sub2 = config + 1;
		} else {
			if (config == 1) {
				sub1 = numHours;
				sub2 = config + 1;
			} else {
				sub1 = config - 1;
				sub2 = 1;
			}
		}
		neighbors.add(sub1);
		neighbors.add(sub2);
		return neighbors;
	}

	/**
	 * returns initial puzzle time
	 * 
	 * @return - ArrayList<Integer> startTime
	 */
	public Integer getStart() {
		return this.startTime;
	}
}
