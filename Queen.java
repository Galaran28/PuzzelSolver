package puzzleSolver;

/**
 * Queen.java
 *
 * File:
 *	$Id: Queen.java,v 1.1 2013/05/03 22:27:18 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Queen.java,v $
 *	Revision 1.1  2013/05/03 22:27:18  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 13:52:10  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Defines Queen piece.
 * @author Chris Sleys
 *
 */
public class Queen extends Piece{

	/**
	 * Initializes inherited values.
	 * @param name Name of Queen
	 * @param X Length of the board on x-axis
	 * @param Y Length of the board on y-axis
	 */
	public Queen(String name, int X, int Y) {
		super(name, X, Y);
	}

	/**
	 * Returns the union of the diagonal moves and the cardinal moves.
	 */
	@Override
	public HashSet<Point> getMoves(Point init) {
		HashSet<Point> moves = super.diagonalMoves(init);
		moves.addAll(super.cardinalMoves(init));
		return moves;
	}
	
}
