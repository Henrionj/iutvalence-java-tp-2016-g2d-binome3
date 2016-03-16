package fr.iutvalence.henrionjulien.chess.piece;


/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public abstract class Piece
{
	/** TODO. */
	private int defaultMove[][];


	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	protected Piece()
	{
		
		this.defaultMove = createMove();
	}
	
	public int[][] allowedMovement() {
		return defaultMove;
	}

	/* TODO Contracts (javadoc) are very important for abstract methods. */
	/**
	 * TODO.
	 *
	 * @return TODO
	 */
	protected abstract int[][] createMove();


}
