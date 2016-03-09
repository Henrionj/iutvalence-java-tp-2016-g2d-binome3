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
		default_move  = create_move();
	}
	
	protected int[][] create_move()
	{
		return super.create_move();
	}
	
}
