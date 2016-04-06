package fr.iutvalence.henrionjulien.chess;

import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.Piece;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Game
{
	/** TODO. */

	private final Board board;
	/** TODO. */

	private final  Player white;
	/** TODO. */

	private  final Player black;
	/** TODO. */
	private int turn = 1;
	/** TODO. */
	private Point currentPiece
				 ,nextCase;
	private Color currentColor;
	
	Scanner s;
	

	/**
	 * TODO.
     */
	public Game()
	{
		this.black = new Player();
		this.white = new Player();
		this.board = new Board();
		this.currentColor = Color.WHITE;
		s = new Scanner(System.in);
	}

	public void run()
	{	
		System.out.println("******game is already running******");
		while(turn!=5)
		{
			System.out.println("turn "+turn);
			this.board.display();
			
			/*
			 * change the color of the player in terms of the turn.
			 */
			if((turn%2) == 0)
			{
				this.currentColor = Color.BLACK;
			}
			else
			{
				this.currentColor = Color.WHITE;
			}
			
			/*
			 * Select the position of the choosenPiece
			 */
			System.out.println("\ndonnez la position x,puis la position y de la piece:");
			this.currentPiece = new Point(s.nextInt(),s.nextInt());
			
			/*
			 *if the piece is posseded by the player, he can select her future move.
			 * 
			 */
			if(isPosseded(this.board.getPieces()[currentPiece.getY()][currentPiece.getX()]))
			{
				System.out.println(this.board.getPieces()[currentPiece.getY()][currentPiece.getX()].toString());
				System.out.println("donnez la position x,puis la position y du déplacement:");
				this.nextCase = new Point(s.nextInt(),s.nextInt());
				move(currentPiece,nextCase);
				turn++;	
			}
			else
			{
				System.out.println("Vous ne possédez pas cette piece!");
			}
		
		}
		
	}
	
	public void move(Point currentPiece, Point nextCase)
	{
		Piece movedPiece = this.board.getPieces()[nextCase.getY()][nextCase.getX()] ;
		board.getPieces()[nextCase.getY()][nextCase.getX()] = board.getPieces()[currentPiece.getY()][currentPiece.getX()];
		board.getPieces()[currentPiece.getY()][currentPiece.getX()] = movedPiece;	
	}
	
	public boolean isPosseded(Piece piece)
	{
		if(this.currentColor == piece.getColor())
			return true;
		return false;
	}
	
	public void exit()
	{
		s.close();	
	}

}
