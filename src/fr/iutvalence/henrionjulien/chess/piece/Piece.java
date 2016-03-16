package fr.iutvalence.henrionjulien.chess.piece;

import fr.iutvalence.henrionjulien.chess.Board;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public abstract class Piece
{
	/** TODO. */
	protected int   defaultMove[][];
	/** TODO. */


	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	protected Piece()
	{
		
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
