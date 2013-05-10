package puzzleSolver;

/**
 * Pawn.java
 *
 * File:
 *	$Id: Pawn.java,v 1.1 2013/05/03 22:27:18 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Pawn.java,v $
 *	Revision 1.1  2013/05/03 22:27:18  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 13:52:10  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Define Pawn piece
 * @author Chris Sleys
 *
 */
public class Pawn extends Piece{
	/**
	 * Initializes inherited values.
	 * @param name Name of Pawn
	 * @param X Length of the board on x-axis
	 * @param Y Length of the board on y-axis
	 */
	public Pawn(String name, int X, int Y) {
		super(name, X, Y);
	}

	/**
	 * Gets forward left and right and checks bounds. Forwards is up on the screen or "away" from the user.
	 */
	@Override
	public HashSet<Point> getMoves(Point init) {
		HashSet<Point> moves = new HashSet<Point>();
		int x = init.getX();
		int y = init.getY();
		moves.add(new Point(x-1, y-1)); // left diagonal
		moves.add(new Point(x+1, y-1)); // right diagonal
		super.checkBounds(moves);
		return moves;
	}
	
}
