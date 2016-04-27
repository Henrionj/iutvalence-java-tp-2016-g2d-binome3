package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;

/**
 * this class is use in order to  simulate a blank case of the board.
 * @author henrionj
 *
 */
public class Blank extends Piece {
	
	public Blank(Color color)
	{
		super(color);
	}
	
	@Override
	protected int[][] createMove() {
		return new int[0][0];
	}

	@Override
	public String toString() {
		return String.format("%s\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		//there is no possible move for the Blank Piece.
		return false;
	}

}
