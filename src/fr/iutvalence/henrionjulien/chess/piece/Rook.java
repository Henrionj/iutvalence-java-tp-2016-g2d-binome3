package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Point;


/**
 * the Rook of a traditional chess game.
 * 
 * @author henrion & murer
 * @version TODO
 */
public class Rook extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Rook(Color color)
	{
		super(color);

	}

	
	@Override
	public String toString() {
		return String.format("[%s Rook]\t",super.toString());
	}

	
	
	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece,Piece p[][]) {
		return false;
	}
	
}
