package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Pawn extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Pawn(Board board)
	{
		super(board);
		// TODO Why don't you use the abstract class? _*/
		defaultMove  = createMove();
	}
	
	protected int[][] createMove()
	{
		return new int[][]{{0},{1}};
	}

}
