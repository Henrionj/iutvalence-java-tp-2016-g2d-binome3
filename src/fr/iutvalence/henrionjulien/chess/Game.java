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
	/** The current color's player of the turn */
	private Color currentColor;
	/**A scanner to catch data from the keyboard.*/
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
			 *verify if the piece is posseded by the player, he can select her future move.
			 * 
			 */
			if(isPosseded(this.board.getPiece(currentPiece)))
			{
				System.out.println(this.board.getPiece(currentPiece).toString());
				System.out.println("donnez la position x,puis la position y du déplacement:");
				this.nextCase = new Point(s.nextInt(),s.nextInt());
				/*
				 * check if the piece of the next move is "eatable" (different color or blank)
				 * and put her in the cemeterY
				 */
				if(this.board.isEatable(board.getPiece(nextCase), 
						board.getPiece(nextCase)))
				{
					board.eat(board.getPiece(nextCase));
					move(currentPiece,nextCase);
					turn++;	
				}
				else
				{
					System.out.println("Mouvement non autorisé, la case contient une autre pièce de même couleur.");
				}
				
			}
			else
			{
				System.out.println("Vous ne possédez pas cette piece!");
			}
		
		}
		
	}
	
	public void move(Point currentPiece, Point nextCase)
	{
		Piece movedPiece = this.board.getPiece(nextCase) ;
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
		System.out.println("******game is exit******");
		s.close();	
	}

}
