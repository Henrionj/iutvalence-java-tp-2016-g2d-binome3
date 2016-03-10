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
		// TODO Why don't you use the abstract class? _*/
		defaultMove  = createMove();
	}

	@Override
	protected int[][] createMove()
	{
		// TODO Transform the next comment into javadoc.
		//[0,8],[0,-8],[8,0],[-8,0] maximal move possible for the rook.
		return new int[][]{{0,0,8,-8},{8,-8,0,0}};
	}
	
}
