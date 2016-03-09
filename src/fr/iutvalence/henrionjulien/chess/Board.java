package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Board
{
	/** Default width of the chessboard. */
	public static final int WIDTH  = 8;
	/** Default height of the chessboard. */
	public static final int HEIGHT = 8;
	/**number of pieces per player**/
	public static final int NUMBER_OF_PIECES = 16;
	/**the board of pieces for one player **/
	private Piece black[];
	private Piece white[];
	

	/** TODO. */
	public Board()
	{
		white = createPieceGame();
		black = createPieceGame();
	}
	/**
	 * TODO.
	 * @param indice
	 * @return
	 */
	
	public Piece getBlackPiece(int indice)
	{
		return black[indice];
	}
	
	/**
	 * TODO.
	 * @param indice
	 * @return
	 */
	public Piece getWhitePiece(int indice)
	{
		return white[indice];
	}
	
	/**
	 * TODO.
	 * @return
	 */
	private Piece[] createPieceGame()
	{
		Piece pieces[] = new Piece[NUMBER_OF_PIECES];
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
		
		return pieces;
	}
}
