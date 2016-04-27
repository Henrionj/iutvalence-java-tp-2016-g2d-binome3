package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;

/**
 * this class is use in order to  simulate a blank case of the board.
 * @author henrionj
 *
 */
public class Blank extends Piece {
	/**
	 * The constructor for a Blank Case.
	 * @param color the color of the Blank Case.
	 */
	public Blank(Color color)
	{
		super(color);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		//there are no possible move for the Blank Piece.
		return false;
	}

}
