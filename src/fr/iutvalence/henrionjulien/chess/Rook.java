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
		defaultMove  = createMove();
		// TODO Auto-generated constructor stub
	}
	protected int[][] createMove()
	{
		int move[][] = {{0,0,8,-8},{8,-8,0,0}};
		//[0,8],[0,-8],[8,0],[-8,0] maximal move possible for the rook.
		return move;
	}
	
}
