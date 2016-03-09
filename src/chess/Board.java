package chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Board
{
	/** Default width of the chessboard. */
	private static final int WIDTH_DEFAULT  = 8;
	/** Default height of the chessboard. */
	private static final int HEIGHT_DEFAULT = 8;
	/**number of pieces per player**/
	private static final int NUMBER_OF_PIECES = 16;
	/**the board of pieces for one player **/
	private Piece pieces[];

	/** TODO. */
	public Board()
	{
		pieces = new Piece[NUMBER_OF_PIECES];
		pieces[0] = new King(this);
		pieces[1] = new Queen(this);
		for (int i = 2; i < 4; i++)
		{
			pieces[i] = new Knight(this);
		}
		for (int i = 4; i < 6; i++)
		{
			pieces[i] = new Rook(this);
		}
		for (int i = 6; i < 8; i++)
		{
			pieces[i] = new Bishop(this);
		}
		for (int i = 8; i < 16; i++)
		{
			pieces[i] = new Pawn(this);
		}
		
	}
	
	public Piece getPiece(int indice)
	{
		return pieces[indice];
	}
}
