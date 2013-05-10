package puzzleSolver;

/**
 * PieceTest.java
 *
 * File:
 *	$Id: PieceTest.java,v 1.1 2013/05/03 22:27:19 cas5420 Exp $
 *
 * Revisions:
 *	$Log: PieceTest.java,v $
 *	Revision 1.1  2013/05/03 22:27:19  cas5420
 *	Finished Puzzle solver, just need to comment.
 *
 *	Revision 1.5  2013/05/03 14:16:34  cas5420
 *	Still debugging solver.
 *
 *	Revision 1.4  2013/05/03 13:52:08  cas5420
 *	Completed chess solver, debugging
 *
 */

public class PieceTest {
	public static void main(String[] args) {
		Piece[] pieces = new Piece[6];
		int x = 3, y = 1, X = 5, Y = 4;

		pieces[0] = new Bishop("Bishop", X, Y);
		pieces[1] = new Knight("Knight", X, Y);
		pieces[2] = new King("King", X, Y);
		pieces[3] = new Pawn("Pawn", X, Y);
		pieces[4] = new Rook("Rook", X, Y);
		pieces[5] = new Queen("Queen", X, Y);
		
		for (Piece p : pieces) {
			System.out.println(p.getName());
			for (Point point : p.getMoves(new Point(x,y))) {
				System.out.println(point);
			}
			System.out.println();
		}
		
		for (int i =0; i < pieces.length; i++) {
			pieces[i] = new Pawn("Pawn", X, Y);
		}
		
		for (Piece p : pieces) {
			System.out.println(p.hashCode());
			
		}
	}
}
