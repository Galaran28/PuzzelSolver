package puzzleSolver;

/**
 * Point.java
 *
 * File:
 *	$Id: Point.java,v 1.1 2013/05/03 22:27:16 cas5420 Exp $
 *
 * Revisions:
 *	$Log: Point.java,v $
 *	Revision 1.1  2013/05/03 22:27:16  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.2  2013/05/03 13:52:11  cas5420
 *	Completed chess solver, debugging
 *
 */

/**
 * Definition of a point.
 * @author Chris Sleys
 *
 */
public class Point {
	private int x, y;

	/**
	 * Initializes values.
	 * @param x x coordinate.
	 * @param y y coordinate.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns x coordinate.
	 * @return x coordinate.
	 */
	public int getX() {return this.x;}
	
	/**
	 * Returns y coordinate.
	 * @return y coordinate.
	 */
	public int getY() {return this.y;}
	
	@Override
	public boolean equals(Object o) {
		Point p = (Point)o;
		if (p.getX() == this.x && p.getY() == this.y) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Merges the point into a single integer value, eg (1,2) becomes 12. This only works for positivate points.
	 */
	@Override
	public int hashCode() {
		if (this.x < 0 || this.y < 0) {
			return -1;
		}
		return Integer.parseInt(String.valueOf(this.x) + String.valueOf(this.y));
	}
	
	@Override
	public String toString() {
		return String.format("[%s,%s]", this.x, this.y);
	}
}
