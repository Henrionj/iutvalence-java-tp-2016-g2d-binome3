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
	private final Color color;

	/**
	 * TODO.
	 * @param color TODO
	 * @param board TODO
     */
	protected Piece(Color color)
	{
		
		this.defaultMove = createMove();
		this.color = color;
	}
	
	public int[][] allowedMovement() {
		return defaultMove;
	}

	/**
	 * 
	 *create the different moves for the pieces
	 * @return an array of maximum moves possible from the pieces
	 */
	protected abstract int[][] createMove();
	
	public Color getColor()
	{
		return this.color;
	}
	
	public String toString() {
		return color.toString();
	}


}
