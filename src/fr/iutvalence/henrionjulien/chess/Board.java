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
	private static final int WIDTH_DEFAULT  = 8;
	/** Default height of the chessboard. */
	private static final int HEIGHT_DEFAULT = 8;
	/**number of pieces per player**/
	private static final int NUMBER_OF_PIECES = 16;
	/**the board of pieces for one player **/
	private Piece black[];
	private Piece white[];

	/** TODO. */
	public Board()
	{
		white = createPieceGame();
		black = createPieceGame();
		
		
		
	}
	
	public Piece getBlackPiece(int indice)
	{
		return black[indice];
	}
	
	public Piece getWhitePiece(int indice)
	{
		return white[indice];
	}
	
	public Piece[] createPieceGame()
	{
		Piece piece[];
		piece = new Piece[NUMBER_OF_PIECES];
		piece[0] = new King(this);
		piece[1] = new Queen(this);
		for (int i = 2; i < 4; i++)
		{
			piece[i] = new Knight(this);
		}
		for (int i = 4; i < 6; i++)
		{
			piece[i] = new Rook(this);
		}
		for (int i = 6; i < 8; i++)
		{
			piece[i] = new Bishop(this);
		}
		for (int i = 8; i < 16; i++)
		{
			piece[i] = new Pawn(this);
		}
		
		return piece;
	}
	
	
	public static int getWidthDefault() {
		return WIDTH_DEFAULT;
	}

	public static int getHeightDefault() {
		return HEIGHT_DEFAULT;
	}
	
	
}
