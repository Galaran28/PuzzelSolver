package puzzleSolver;

/**
 * King.java
 *
 * File:
 *	$Id: King.java,v 1.1 2013/05/03 22:27:18 cas5420 Exp $
 *
 * Revisions:
 *	$Log: King.java,v $
 *	Revision 1.1  2013/05/03 22:27:18  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 13:52:09  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Defines King piece
 * @author Chris Sleys
 *
 */
public class King extends Piece{
	/**
	 * Initializes inherited values.
	 * @param name Name of King
	 * @param X Length of the board on x-axis
	 * @param Y Length of the board on y-axis
	 */
	public King(String name, int X, int Y) {
		super(name, X, Y);
	}

	/**
	 * Returns every point surrounding the start and removes any that are out of bounds.
	 */
	@Override
	public HashSet<Point> getMoves(Point init) {
		HashSet<Point> moves = new HashSet<Point>();
		int x = init.getX();
		int y = init.getY();
		moves.add(new Point(x-1, y-1)); // left front diagonal
		moves.add(new Point(x+1, y-1)); // right front diagonal
		moves.add(new Point(x-1, y+1)); // left rear diagonal
		moves.add(new Point(x+1, y+1)); // right rear diagonal
		moves.add(new Point(x, y-1)); // north
		moves.add(new Point(x, y+1)); // south
		moves.add(new Point(x+1, y)); // east
		moves.add(new Point(x-1, y)); // west
		super.checkBounds(moves);
		return moves;
	}

}
