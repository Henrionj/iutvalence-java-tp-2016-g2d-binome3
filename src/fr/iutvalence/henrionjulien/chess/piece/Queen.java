package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Queen of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Queen extends Piece
{

	/**
	 * TODO.
	 *
	 * 
     */
	public Queen(Color color)
	{
		super(color);

	}

	@Override
	public String toString() {
		return String.format("[%s Queen]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
