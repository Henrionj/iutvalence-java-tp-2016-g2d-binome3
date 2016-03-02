/**
 * 
 */
package chess;

/**
 * @author henrion & murer
 *
 */
public class Player
{
	private final static int NUMBER_OF_PIECES = 16;
	private Piece pieces[];
	
	public Player(Board board)
	{
		pieces = new Piece[NUMBER_OF_PIECES];
		pieces[0] = new King(board);
		pieces[1] = new Queen(board);
		for (int i = 2; i < 4; i++)
		{
			pieces[i] = new Knight(board);
		}
		for (int i = 4; i < 6; i++)
		{
			pieces[i] = new Rook(board);
		}
		for (int i = 6; i < 8; i++)
		{
			pieces[i] = new Bishop(board);
		}
		for (int i = 8; i < 16; i++)
		{
			pieces[i] = new Pawn(board);
		}
	}
	
	public Piece getPiece(int indice)
	{
		return pieces[indice];
	}
}
