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
		defaultMove  = createMove();
		// TODO Auto-generated constructor stub
	}
	
	protected int[][] createMove()
	{
		int move[][] = {{8,-8,-8,8},{8,-8,8,-8}};//[8,8],[-8,-8],[-8,8],[8,-8] maximal move possible for the bishop.
		return move;
	}
	
}
