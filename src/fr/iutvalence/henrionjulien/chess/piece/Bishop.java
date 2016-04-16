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
	 * @param board TODO.
     */
	public Bishop(Color color)
	{
		super(color);
	}

	/**
	 * [8,8],[-8,-8],[-8,8],[8,-8] maximal move possible for the bishop.
	 */
	@Override
	protected int[][] createMove()
	{
		return new int[][]{{8,-8,-8,8},{8,-8,8,-8}};
	}
	
	@Override
	public String toString() {
		return String.format("[%s Bishop]\t",super.toString());
	}

	@Override
	public boolean moveIsPossible(Point currentPiece, Point nextPiece) {
		// TODO Auto-generated method stub
		return false;
	}


}
