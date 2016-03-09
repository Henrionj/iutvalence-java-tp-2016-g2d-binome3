package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Piece
{

	protected int default_move[][];
	protected Board board;
	
	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Piece(Board board)
	{
		this.board = board;
	}

	protected int[][] create_move()
	{
		int move[][] = {{0},{1}};
		return move;
	}
}
