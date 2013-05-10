package puzzleSolver;

/**
 *
 *File:
 *	$Id: Puzzle.java,v 1.6 2013/05/03 13:52:11 cas5420 Exp $
 *
 *Revisions
 *	$Log: Puzzle.java,v $
 *	Revision 1.6  2013/05/03 13:52:11  cas5420
 *	Completed chess solver, debugging
 *
 *	Revision 1.5  2013/05/01 11:46:16  cas5420
 *	Updated solver to generics
 *
 *	Revision 1.4  2013/04/27 13:00:59  cas5420
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

public interface Puzzle<E> {
	/**
	 * Checks if config is the solution to the puzzle
	 * 
	 * @return true if config is the solution.
	 */
	public boolean isGoal(E config);

	/**
	 * For an incoming config, generate and return all direct neighbors to this
	 * config
	 * 
	 * @param config
	 *            - the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<E> getNeighbors(E config);

	/**
	 * Get the starting config for this puzzle
	 * 
	 * @return the starting config
	 */
	public E getStart();
}
