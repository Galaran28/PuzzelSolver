package puzzleSolver;

/**
 *
 *File:
 *	$Id: Solver.java,v 1.6 2013/05/03 13:52:11 cas5420 Exp $
 *
 *Revisions
 *	$Log: Solver.java,v $
 *	Revision 1.6  2013/05/03 13:52:11  cas5420
 *	Completed chess solver, debugging
 *
 *	Revision 1.5  2013/05/01 11:46:16  cas5420
 *	Updated solver to generics
 *
 *	Revision 1.4  2013/04/27 13:01:00  cas5420
 *	Started project
 *
 *	Revision 1.2  2013/04/14 20:50:52  mgp9795
 *	Part 2 Adjustments
 *
 *	Revision 1.1  2013/04/01 19:41:43  mgp9795
 *	Initial Version
 *
 */

/**
 * @author Michael
 * @author Chris Sleys
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Solver<E> {
	/**
	 * Solves a puzzle
	 * 
	 * @param puzzle
	 *            - the puzzle to be solved
	 * @return ArrayList holding solution
	 */
	public ArrayList<E> solve(Puzzle<E> puzzle) {
		HashSet<E> visited = new HashSet<E>();
		ArrayList<ArrayList<E>> queue = new ArrayList<ArrayList<E>>();
		ArrayList<E> startConfig = new ArrayList<E>();
		ArrayList<E> current = null;
		startConfig.add(puzzle.getStart());
		boolean found = puzzle.isGoal(puzzle.getStart());
		queue.add(startConfig);
		visited.add(puzzle.getStart());
		while (!queue.isEmpty() && !found) {
			current = queue.remove(0);
			ArrayList<E> neighbors = puzzle.getNeighbors(current.get(current.size() - 1));
			for (E neighbor : neighbors) {
				if (!visited.contains(neighbor)) {
					ArrayList<E> nextConfig = new ArrayList<E>();
					for (E item : current) {
						nextConfig.add(item);
					}
					nextConfig.add(neighbor);
					if (puzzle.isGoal(nextConfig.get(nextConfig.size() - 1))) {
						current = nextConfig;
						found = true;
						break;
					} else {
						queue.add(nextConfig);
					}
					visited.add(neighbor);
				}
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}
	}
}
