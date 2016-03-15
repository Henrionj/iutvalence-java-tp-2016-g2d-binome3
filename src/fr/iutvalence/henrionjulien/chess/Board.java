package fr.iutvalence.henrionjulien.chess;

import fr.iutvalence.henrionjulien.chess.piece.Bishop;
import fr.iutvalence.henrionjulien.chess.piece.King;
import fr.iutvalence.henrionjulien.chess.piece.Knight;
import fr.iutvalence.henrionjulien.chess.piece.Pawn;
import fr.iutvalence.henrionjulien.chess.piece.Piece;
import fr.iutvalence.henrionjulien.chess.piece.Queen;
import fr.iutvalence.henrionjulien.chess.piece.Rook;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Board
{
	/** Chessboard's width. */
	public static final int WIDTH  = 8;
	/** Chessboard's height. */
	public static final int HEIGHT = 8;
	/** Number of pieces per player. **/
	public static final int NUMBER_OF_PIECES = 16;
	/** All the black pieces. */
	/* TODO final? */
	private Piece black[];
	/** All the white pieces. */
	/* TODO final? */
	private Piece white[];


	/** TODO. */
	public Board()
	{
		white = createPieceGame();
		black = createPieceGame();
	}

	/**
	 * TODO.
     *
	 * @param indice TODO
	 * @return TOOD
	 */

	public Piece getBlackPiece(int indice)
	{
		return black[indice];
	}

	/**
	 * TODO.
     *
	 * @param indice TODO
	 * @return TODO
	 */
	public Piece getWhitePiece(int indice)
	{
		return white[indice];
	}

	/**
	 * TODO.
     *
	 * @return TODO
	 */
	private Piece[] createPieceGame()
	{
        Piece[] pieces = new Piece[NUMBER_OF_PIECES];
		pieces[0] = new King(this);
		pieces[1] = new Queen(this);
        pieces[2] = new Knight(this);
        pieces[3] = new Knight(this);
        pieces[4] = new Rook(this);
        pieces[5] = new Rook(this);
        pieces[6] = new Bishop(this);
        pieces[7] = new Bishop(this);

		for (int i = 8; i < 16; i++)
		{
			pieces[i] = new Pawn(this);
		}

		return pieces;
	}
}
