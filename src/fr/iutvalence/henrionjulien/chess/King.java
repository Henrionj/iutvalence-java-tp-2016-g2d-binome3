package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class King extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO.
     */
	public King(Board board)
	{
		super(board);
		defaultMove  = createMove();
		// TODO Auto-generated constructor stub
	}
	protected int[][] createMove()
	{
		int move[][] = {{1,-1,-1,1,0,0,1,-1},{1,-1,1,-1,1,-1,0,0}};
		//[1,1],[-1,-1],[-1,1],[1,-1],[0,1],[0,-1],[1,0],[-1,0] maximal move possible for the king.
		return move;
	}
	
}
