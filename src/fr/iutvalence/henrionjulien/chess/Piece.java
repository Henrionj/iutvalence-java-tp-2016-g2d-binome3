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

	// TODO This constructor is "protected" not "public". */
	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Piece(Board board)
	{
		this.board = board;
	}

	/* TODO Contracts (javadoc) are very important for abstract methods. */
	/**
	 * TODO.
	 *
	 * @return TODO
	 */
	protected abstract int[][] createMove();

}
