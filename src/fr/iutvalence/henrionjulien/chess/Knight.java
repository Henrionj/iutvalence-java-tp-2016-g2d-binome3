package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Knight extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Knight(Board board)
	{
		super(board);
		default_move  = create_move();
		// TODO Auto-generated constructor stub
	}
	protected int[][] create_move()
	{
		int move[][] = {{2,1,-1,-2,-2,-1,1,2},{-1,-2,-2,-1,1,2,2,1}};
		//[2,-1],[1,-2],[-1,-2],[-2,-1],[-2,1],[-1,2],[1,2],[2,1] maximal move possible for the knight.
		return move;
	}
	
}
