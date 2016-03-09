package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public abstract class Piece
{
	protected int defaultMove[][];
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

	/**
	 * TODO.
	 * @return
	 */
	protected abstract int[][] createMove();

}
