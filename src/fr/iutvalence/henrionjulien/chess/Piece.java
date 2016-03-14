package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public abstract class Piece
{
	/** TODO. */
	protected int defaultMove[][];
	/** TODO. */
	/* TODO I think this is a bad idea… but… why not in a first attempt. */
	protected Board board;

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	protected Piece(Board board)
	{
		this.board = board;
		this.defaultMove = createMove();
	}

	/* TODO Contracts (javadoc) are very important for abstract methods. */
	/**
	 * TODO.
	 *
	 * @return TODO
	 */
	protected abstract int[][] createMove();

}
