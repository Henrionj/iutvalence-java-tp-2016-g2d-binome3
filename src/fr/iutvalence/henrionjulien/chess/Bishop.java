package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
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
	public Bishop(Board board)
	{
		super(board);
	}

	protected int[][] createMove()
	{
		/**
		 * [8,8],[-8,-8],[-8,8],[8,-8] maximal move possible for the bishop.
		 */
		return new int[][]{{8,-8,-8,8},{8,-8,8,-8}};
	}

}
