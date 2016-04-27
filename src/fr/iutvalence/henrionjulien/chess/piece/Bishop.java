package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Bishop of a traditional chess game.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Bishop extends Piece
{

	/**
	 * TODO.
	 *
	 *
     */
	public Bishop(Color color)
	{
		super(color);
	}

	
	@Override
	public String toString() {
		return String.format("[%s Bishop]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		// TODO Auto-generated method stub
		return false;
	}


}
