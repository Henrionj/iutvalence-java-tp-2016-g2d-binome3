package fr.iutvalence.henrionjulien.chess;

import fr.iutvalence.henrionjulien.chess.piece.Bishop;
import fr.iutvalence.henrionjulien.chess.piece.Blank;
import fr.iutvalence.henrionjulien.chess.piece.Color;
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

	/** the board of pieces of the game*/
	private Piece pieces[][];

	/** TODO. */
	public Board()
	{
		pieces = createPieceGame();
		createBoard();
		
	}

	/**
	 * TODO.
     *
	 * @return TODO
	 */
	private Piece[][] createPieceGame()
	{
      
		Piece[][] pieces = new Piece[this.WIDTH][this.HEIGHT];
		/**
		 * pieces of one player
		 */
		pieces[0][0] = new Rook(Color.BLACK);
		pieces[1][0] = new Knight(Color.BLACK);
		pieces[2][0] = new Bishop(Color.BLACK);
		pieces[3][0] = new Queen(Color.BLACK);
		pieces[4][0] = new King(Color.BLACK);
		pieces[5][0] = new Bishop(Color.BLACK);
		pieces[6][0] = new Knight(Color.BLACK);
		pieces[7][0] = new Rook(Color.BLACK);
		for (int i = 0; i < 8; i++)
		{
			pieces[i][1] = new Pawn(Color.BLACK);
			pieces[i][6] = new Pawn(Color.WHITE);
		}
		/**
		 * pieces of the latter
		 */
		
		pieces[0][7] = new Rook(Color.WHITE);
		pieces[1][7] = new Knight(Color.WHITE);
		pieces[2][7] = new Bishop(Color.WHITE);
		pieces[3][7] = new Queen(Color.WHITE);
		pieces[4][7] = new King(Color.WHITE);
		pieces[5][7] = new Bishop(Color.WHITE);
		pieces[6][7] = new Knight(Color.WHITE);
		pieces[7][7] = new Rook(Color.WHITE);


		
		for(int i = 2;i <6;i++)
		{
			for(int j = 0;j<8;j++)
			{
				pieces[j][i] = new Blank(Color.BLANK);
			}
		}

		return pieces;
	}
	
	private void createBoard()
	{
		for(int i = 0;i<HEIGHT;i++)
		{
			System.out.println();
			for(int j = 0;j<WIDTH;j++)
			{
				System.out.print(pieces[i][j]);
							}
		}
	
	}








}
