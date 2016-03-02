package chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Piece
{
	/* Is it interesting or even useful to retain the position of the Piece on the board in the Piece? */
	/** TODO. */
	private int posX;
	/** TODO. */
	private int posY;

	/**
	 * TODO.
	 *
	 * @param board TODO
     */
	public Piece(Board board)
	{
		
	}

	/**
	 * TODO.
	 *
	 * @return TODO
     */
	public int getPosX()
	{
		return posX;
	}

	/**
	 * TODO.
	 *
	 * @param posX TODO
     */
	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	/**
	 * TODO.
	 *
	 * @return TODO
	 */
	public int getPosY()
	{
		return posY;
	}

	/**
	 * TODO.
	 *
	 * @param posY TODO
     */
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
}
