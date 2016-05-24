package fr.iutvalence.henrionjulien.chess;

import java.util.ArrayList;
import java.util.List;

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
 * the array which represent a chessboard ,with his pieces.
 *
 * @author henrion & murer
 * @version V1
 */
public class Board
{
	/** The width of the chessboard. */
	public static final int WIDTH  = 8;
	/** The height of the chessboard. */
	public static final int HEIGHT = 8;
	/** number of the pieces per player */
	public static final int PIECE_NUMBER = 16;

	/** the pieces of the game*/
	private Piece pieces[][];
	
	/** cemetery of black pieces eaten by the oppenent */
	private final List<Piece> blackCemetery;
	/** cemetery of white pieces eaten by the oppenent */
	private final List<Piece> whiteCemetery;
	
	
	/** 
	 * The constructor of the board.
	 *
	 */
	public Board()
	{
		pieces = createPieceGame();
		blackCemetery = new ArrayList<Piece>(16);
		whiteCemetery = new ArrayList<Piece>(16);
		
	}

	/**
	 *Initialize an array of pieces.
     *
	 * @return an array which contain every pieces from a normal chess game.
	 */
	private Piece[][] createPieceGame()
	{
      
		Piece[][] pieces = new Piece[Board.WIDTH][Board.HEIGHT];
		/*
		 * pieces of one player(black)
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
		
		  //pieces of the latter(white)
		 
		
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
				pieces[i][j] = new Blank();
			}
		}

		return pieces;
	}
	
	/** Display the array in the console
	 * 
	 */
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
		return (pieces[y][x].getColor() == Color.BLANK );
	}
/**
 * *
 * @param piece
 * @return The piece from the position where she belong on the board.
 */
	public Piece getPiece(Point piece) {
		return pieces[piece.getY()][piece.getX()];
	}
	
	/**
	 * 
	 * @return the array of pieces
	 */
	public Piece[][] getPieces()
	{
		return pieces;
	}
	/**
	 * 
	 * @param getPiece(currentPiece)  Piece selected by the player
	 * @param getPiece(nextCase)   Next movement 
	 * @return true if the piece can be eat ( i.e a black piece can eat a white piece) 
	 */
	public boolean isEatable(Point currentPiece, Point nextCase)
	{
		return (getPiece(currentPiece).getColor() != getPiece(nextCase).getColor());
	}
	/**
	 * Eat the opponent piece's
	 * 
	 * @param choosePiece
	 */
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
	 * Reverse the chessboard in order to create the same view for each players.
	 * 
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
/**
 * 
 * @return The black cemetery.
 */
	public List<Piece> getBlackCemetery() {
		return blackCemetery;
	}
/**
 * 
 * @return The white cemetery.
 */
	public List<Piece> getWhiteCemetery() {
		return whiteCemetery;
	}
	
	/**
	 * Allow the movement of one piece.
	 * @param currentPiece The piece selected by the player
	 * @param nextCase The next position of piece selected
	 */
	public void move(Point currentPiece, Point nextCase)
	{
		this.pieces[nextCase.getY()][nextCase.getX()] = pieces[currentPiece.getY()][currentPiece.getX()];
		this.pieces[currentPiece.getY()][currentPiece.getX()] = new Blank();	
	}
	/**
	 * Method that promote a pawn into a existing piece from the player cemetery.
	 * 
	 * @param ans The answer to choose the piece.
	 * @param current The current position.
	 * @param c The color of the piece needed.
	 */
	public void promote(int ans,Point current,Color c)
	{
		if(c == Color.WHITE)
		{
			this.pieces[current.getY()][current.getX()] = this.getWhiteCemetery().get(ans);
		}
		
		if(c == Color.BLACK)
		{
			this.pieces[current.getY()][current.getX()] = this.getBlackCemetery().get(ans);
		}
	}
	/**
	 * Check is the king have been moved during the game
	 * This method is needed for the castling.
	 * @param current The current position.
	 */
	public void moveKing(Point current)
	{
	this.pieces[current.getY()][current.getX()].Moved();
	}
	

	


}
