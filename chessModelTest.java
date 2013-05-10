package puzzleSolver;

/**
 * chessModelTest.java
 *
 * File:
 *	$Id: chessModelTest.java,v 1.2 2013/05/03 23:22:12 cas5420 Exp $
 *
 * Revisions:
 *	$Log: chessModelTest.java,v $
 *	Revision 1.2  2013/05/03 23:22:12  cas5420
 *	Finished commenting.
 *
 *	Revision 1.1  2013/05/03 22:27:18  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.3  2013/05/03 14:16:32  cas5420
 *	Still debugging solver.
 *
 *	Revision 1.2  2013/05/03 13:52:08  cas5420
 *	Completed chess solver, debugging
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Testing sweet for ChessModel.java
 * @author Chris Sleys
 *
 */
public class chessModelTest {
	public static void main(String[] args) {
		Solver<HashMap<Point, Piece>> s = new Solver<HashMap<Point, Piece>>();
		ChessModel cm = new ChessModel(new File(args[0]));
		ArrayList<HashMap<Point, Piece>> solution = s.solve(cm);

		if (solution != null) {
			for (HashMap<Point, Piece> b : solution) {
				System.out.println(b);
			}
		} else {
			System.out.println("No solution");
		}
	}
}
