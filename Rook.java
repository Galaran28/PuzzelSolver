package puzzleSolver;

/**
 * Rook.java
 *
 * File:
 *	$Id: Rook.java,v 1.1 2013/05/03 22:27:17 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Rook.java,v $
 *	Revision 1.1  2013/05/03 22:27:17  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 13:52:10  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Defines Rook piece.
 * @author Chris Sleys
 *
 */
public class Rook extends Piece{
	/**
	 * Initializes inherited values.
	 * @param name Name of Rook
	 * @param X Length of the board on x-axis
	 * @param Y Length of the board on y-axis
	 */
	public Rook(String name, int X, int Y) {
		super(name, X, Y);
	}

	@Override
	public HashSet<Point> getMoves(Point init) {
		return super.cardinalMoves(init);
	}
}
