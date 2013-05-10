package puzzleSolver;

/**
 * Knight.java
 *
 * File:
 *	$Id: Knight.java,v 1.1 2013/05/03 22:27:17 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Knight.java,v $
 *	Revision 1.1  2013/05/03 22:27:17  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 13:52:09  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Defines Knight piece.
 * @author Chris Sleys
 *
 */
public class Knight extends Piece{
	/**
	 * Initializes inherited values.
	 * @param name Name of Knight
	 * @param X Length of the board on x-axis
	 * @param Y Length of the board on y-axis
	 */
	public Knight(String name, int X, int Y) {
		super(name, X, Y);
	}

	/**
	 * Returns every L shaped endpoint with bounds checked.
	 */
	@Override
	public HashSet<Point> getMoves(Point init) {
		HashSet<Point> moves = new HashSet<Point>();
		int x = init.getX();
		int y = init.getY();
		moves.add(new Point(x+1, y-2)); // north east
		moves.add(new Point(x-1, y-2)); // north west
		moves.add(new Point(x+1, y+2)); // south east
		moves.add(new Point(x-1, y+2)); // south west
		moves.add(new Point(x+2, y-1)); // east north
		moves.add(new Point(x+2, y+1)); // east south
		moves.add(new Point(x-2, y-1)); // west north
		moves.add(new Point(x-2, y+1)); // west south
		super.checkBounds(moves);
		return moves;
	}
}
