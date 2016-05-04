package fr.iutvalence.henrionjulien.chess;

import java.util.ArrayList;

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
	/** number of the pieces per player */
	public static final int PIECE_NUMBER = 16;

	/** the board of pieces of the game*/
	private Piece pieces[][];
	
	/** cemetery of black pieces eaten by the oppenent */
	private ArrayList<Piece> blackCemetery;
	/** cemetery of white pieces eaten by the oppenent */
	private ArrayList<Piece> whiteCemetery;
	
	
	/** TODO. */
	public Board()
	{
		pieces = createPieceGame();
		blackCemetery = new ArrayList();
		whiteCemetery = new ArrayList();
		
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
		pieces[0][1] = new Knight(Color.BLACK);
		pieces[0][2] = new Bishop(Color.BLACK);
		pieces[0][3] = new Queen(Color.BLACK);
		pieces[0][4] = new King(Color.BLACK);
		pieces[0][5] = new Bishop(Color.BLACK);
		pieces[0][6] = new Knight(Color.BLACK);
		pieces[0][7] = new Rook(Color.BLACK);
		for (int i = 0; i < 8; i++)
		{
			pieces[1][i] = new Pawn(Color.BLACK);
			pieces[6][i] = new Pawn(Color.WHITE);
		}
		
		  //pieces of the latter
		 
		
		pieces[7][0] = new Rook(Color.WHITE);
		pieces[7][1] = new Knight(Color.WHITE);
		pieces[7][2] = new Bishop(Color.WHITE);
		pieces[7][3] = new Queen(Color.WHITE);
		pieces[7][4] = new King(Color.WHITE);
		pieces[7][5] = new Bishop(Color.WHITE);
		pieces[7][6] = new Knight(Color.WHITE);
		pieces[7][7] = new Rook(Color.WHITE);
		


		
		for(int i = 2;i <6;i++)
		{
			for(int j = 0;j<8;j++)
			{
				pieces[i][j] = new Blank(Color.BLANK);
			}
		}

		return pieces;
	}
	
	public void display()
	{
		for(int j = 0;j<WIDTH;j++)
		{
			System.out.print(String.format("\t[%s ]\t",j));
						}
		for(int i = 0;i<HEIGHT;i++)
		{	
			System.out.println();
			System.out.print(String.format("[%s ]\t",i));
			for(int j = 0;j<WIDTH;j++)
			{
				System.out.print(pieces[i][j]);
							}
		}
	
	}
	
	/**
	 * 
	 * Check if the case of the board is empty.
	 * @param x the horinzontal coordonate.
	 * @param y the vertical coordonate.
	 * @param pieces current board of pieces.
	 * @return  true if the case is empty, false for anything else.
	 */
	public boolean isEmpty(int x,int y,Piece pieces[][])
	{
		if (pieces[y][x].getColor() == Color.BLANK )
			return true;
		
		return false;		
	}

	public Piece getPiece(Point piece) {
		return pieces[piece.getY()][piece.getX()];
	}
	
	public Piece[][] getPieces()
	{
		return pieces;
	}
	
	public boolean isEatable(Piece currentPiece, Piece choosePiece)
	{
		if(currentPiece.getColor() == choosePiece.getColor())
			return false;		
		
		return true;
	}
	
	public void eat(Piece choosePiece)
	{
		if(choosePiece.getColor() == Color.BLACK && !choosePiece.isPawn())
		{
			blackCemetery.add(choosePiece);
		}
		if(choosePiece.getColor() == Color.WHITE && !choosePiece.isPawn())
		{
			whiteCemetery.add(choosePiece);
		}
	}
	
	/**
	 * TODO
	 */
	public void invertBoard()
	{
		Piece p[][] = new Piece[this.WIDTH][this.HEIGHT];
		int i = 7,
			j = 0,
			y = 7,
			x = 0;
		
		while(j<=7)
		{
			while(i>=0)
			{
				p[j][i] = this.pieces[y][x];
				i--;
				x++;
			}
			j++;
			y--;
			x = 0;
			i = 7;
		}
		this.pieces = p;
	}

	public ArrayList<Piece> getBlackCemetery() {
		return blackCemetery;
	}

	public ArrayList<Piece> getWhiteCemetery() {
		return whiteCemetery;
	}
	
	

	


}
