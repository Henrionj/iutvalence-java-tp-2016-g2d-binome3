package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Queen extends Piece
{

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Queen(Board board)
	{
		super(board);
		default_move  = create_move();
		// TODO Auto-generated constructor stub
	}
	
	protected int[][] create_move()
	{
		int move[][] = {{8,-8,-8,8,0,0,8,-8},{8,-8,8,-8,8,-8,0,0}};
		//[8,8],[-8,-8],[-8,8],[8,-8],[0,8],[0,-8],[8,0],[-8,0] maximal move possible for the queen.
		return move;
	}
	
}
