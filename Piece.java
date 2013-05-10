package puzzleSolver;

/**
 * Piece.java
 *
 * File:
 *	$Id: Piece.java,v 1.3 2013/05/03 22:27:18 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Piece.java,v $
 *	Revision 1.3  2013/05/03 22:27:18  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.4  2013/05/03 13:52:10  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.util.HashSet;

/**
 * Base definition of a piece.
 * 
 * @author Chris Sleys
 * 
 */
public abstract class Piece {
	private String name;
	private int X, Y, localInstanceNum;
	private static int numInstances = 0;

	/**
	 * Initializes the name of the piece and the size of the board its on.
	 * 
	 * @param name
	 *            Desired name.
	 * @param X
	 *            Length of the board on x-axis
	 * @param Y
	 *            Length of the board on y-axis
	 */
	public Piece(String name, int X, int Y) {
		this.name = name;
		this.X = X;
		this.Y = Y;
		this.localInstanceNum = numInstances;
		numInstances += 1;
	}

	/**
	 * Returns name of Piece
	 * 
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Take in x,y coordinates and finds all valid moves for this Piece
	 * 
	 * @param x
	 *            Starting x value
	 * @param y
	 *            Starting y value
	 * @return Set of all valid moves.
	 */
	public abstract HashSet<Point> getMoves(Point init);

	/**
	 * Takes in a point and finds all moves diagonal to it.
	 * 
	 * @param init
	 *            Initial point.
	 * @return Set of moves.
	 */
	protected HashSet<Point> diagonalMoves(Point init) {
		HashSet<Point> moves = new HashSet<Point>();
		int xTemp = init.getX(), yTemp = init.getY();

		// get lower right
		while (xTemp < this.X && yTemp < this.Y) {
			moves.add(new Point(xTemp, yTemp));
			xTemp++;
			yTemp++;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get upper left
		while (xTemp >= 0 && yTemp >= 0) {
			moves.add(new Point(xTemp, yTemp));
			xTemp--;
			yTemp--;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get lower left
		while (xTemp >= 0 && yTemp < this.Y) {
			moves.add(new Point(xTemp, yTemp));
			xTemp--;
			yTemp++;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get lower right
		while (xTemp < this.X && yTemp >= 0) {
			moves.add(new Point(xTemp, yTemp));
			xTemp++;
			yTemp--;
		}

		moves.remove(init); // remove current location

		return moves;
	}

	/**
	 * Takes in a point and finds all moves on the cardinal lines.
	 * 
	 * @param init
	 *            Initial point.
	 * @return Set of moves.
	 */
	protected HashSet<Point> cardinalMoves(Point init) {
		HashSet<Point> moves = new HashSet<Point>();
		int xTemp = init.getX(), yTemp = init.getY();

		// get north
		while (yTemp >= 0) {
			moves.add(new Point(init.getX(), yTemp));
			yTemp--;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get south
		while (yTemp < this.Y) {
			moves.add(new Point(init.getX(), yTemp));
			yTemp++;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get east
		while (xTemp < this.X) {
			moves.add(new Point(xTemp, init.getY()));
			xTemp++;
		}

		xTemp = init.getX();
		yTemp = init.getY();

		// get west
		while (xTemp >= 0) {
			moves.add(new Point(xTemp, init.getY()));
			xTemp--;
		}

		moves.remove(init); // remove current location

		return moves;
	}

	/**
	 * Takes a set of moves and makes sure that none of them are off the board.
	 * 
	 * @param set
	 *            Set of moves.
	 * @return Set of moves with all the out of bounds moves removed.
	 */
	protected HashSet<Point> checkBounds(HashSet<Point> set) {
		HashSet<Point> toRemove = new HashSet<Point>();
		for (Point p : set) {
			if (p.getX() < 0 || p.getX() >= this.X || p.getY() < 0
					|| p.getY() >= this.Y) {
				toRemove.add(p);
			}
		}
		
		// Must be split into two steps to avoid concurent modification.
		for (Point p : toRemove) {
			set.remove(p);
		}
		return set;
	}

	public String toString() {
		return name;
	}
	
	public int hashCode() {
		int ret = 0;
		for (char c : this.name.toCharArray()) {
			ret += (int) c;
		}
		return ret * this.localInstanceNum;
	}
	/*
	 * Used for testing purposes public static void main(String[] args) { int x
	 * = 1, y = 2, X = 5, Y = 5; Piece p = new Piece("Test"); HashSet<Point> cm
	 * = p.cardinalMoves(x, y, X, Y); HashSet<Point> dm = p.diagonalMoves(x, y,
	 * X, Y);
	 * 
	 * for (Point point : cm) { System.out.println(point.getX() + "," +
	 * point.getY()); }
	 * 
	 * System.out.println();
	 * 
	 * for (Point point : dm) { System.out.println(point.getX() + "," +
	 * point.getY()); }
	 * 
	 * System.out.println(); cm.addAll(dm);
	 * 
	 * for (Point point : cm) { System.out.println(point.getX() + "," +
	 * point.getY()); } }
	 */
}
