package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
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
	public Rook(Board board)
	{
		super(board);

	}

	@Override
	protected int[][] createMove()
	{
		
		/**
		 * [0,8],[0,-8],[8,0],[-8,0] maximal move possible for the rook.
		 */
		return new int[][]{{0,0,8,-8},{8,-8,0,0}};
	}
	
}
