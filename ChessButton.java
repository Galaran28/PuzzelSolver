package puzzleSolver;

import javax.swing.JButton;

/**
 * Adds positional data to a JButton.
 * 
 * @author Chris Sleys
 * 
 */
public class ChessButton extends JButton {
	Point pos;

	/**
	 * Takes in an x and y coordinates represengin its location.
	 * 
	 * @param x x-coordinate of button.
	 * @param y y-coordinate of button.
	 */
	public ChessButton(int x, int y) {
		this.pos = new Point(x, y);
	}

	/**
	 * Returns the position.
	 * 
	 * @return The position.
	 */
	public Point getPos() {
		return pos;
	}
}
