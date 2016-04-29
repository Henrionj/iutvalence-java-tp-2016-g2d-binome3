package fr.iutvalence.henrionjulien.chess;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Blank;
import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.King;
import fr.iutvalence.henrionjulien.chess.piece.NoMoveException;
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


	/** TODO. */
	private int turn = 1;
	/** TODO. */
	private Point currentPiece = null
				 ,nextCase = null;
	/** The current color's player of the turn */
	private Color currentColor;
	/**A scanner to catch data from the keyboard.*/
	private boolean KingIsDead;
	

	/**
	 * TODO.
     */
	public Game()
	{
		this.board = new Board();
		this.KingIsDead = false;
		this.currentColor = Color.WHITE;
	}

	public void run()
	{	
		System.out.println("******game is already running******");
		while(this.KingIsDead == false)
		{
			this.newTurn();
 			while(this.currentPiece == null)
			{
				this.currentPiece = null;
				System.out.println("\ndonnez la position x,puis la position y de la piece:");	
				try 
					{
					 this.currentPiece = this.askPosition(this.currentPiece);
					}
				catch (PointException e)
					{
						System.out.println("Coordonnées invalides, veuillez saisir un chiffre entre 0 et 7 pour x et y.");
					}
			}
			/*
			 *verify if the piece is posseded by the player, he can select her future move.
			 * 
			 */
			if(isPosseded(this.board.getPiece(currentPiece)))
			{
				System.out.println(this.board.getPiece(currentPiece).toString());
				while(this.nextCase == null)
				{
					System.out.println("donnez la position x,puis la position y du déplacement:");
					try 
						{
						this.nextCase = this.askPosition(this.nextCase);
						}
					catch (PointException e)
						{
							System.out.println("Coordonnées invalides, veuillez saisir un chiffre entre 0 et 7 pour x et y.");
							this.nextCase = null;
						}
				}
				/*
				 * check if the piece of the next move is "eatable" (different color or blank)
				 * and put her in the cemetery
				 */
				try {
					if(this.board.getPiece(currentPiece).moveIsPossible(currentPiece, nextCase, board.getPieces()))
						{
							if(this.board.isEatable(board.getPiece(currentPiece), 
									board.getPiece(nextCase)))
							{
								if(board.getPiece(nextCase).getClass() == new King(Color.BLACK).getClass())
									KingIsDead = true;
								board.eat(board.getPiece(nextCase));
								move(currentPiece,nextCase);
								turn++;	
								board.invertBoard();
							}
							else
							{
								System.out.println("Mouvement non autorisé, la case contient une autre pièce de même couleur.");
							}
							
						}
					else
					{
						System.out.println("mouvement non autorisé, la pièce ne peut faire un tel mouvement.");
					}
				} catch (NoMoveException e) {
					System.out.println("Vous ne pouvez pas déplacer la pièce sur elle même!");
				}
				
			}
			
			else
			{
				System.out.println("Vous ne possédez pas cette piece!");
			}
		}
		if(this.currentColor == Color.WHITE)
			System.out.println("Les Blancs gagnent");
		if(this.currentColor == Color.BLACK)
			System.out.println("Les Noirs gagnent");
		
		this.exit();
		
	}
	
	public void exit()
	{
		System.out.println("******exit******");
	}
	
	public void move(Point currentPiece, Point nextCase)
	{
		board.getPieces()[nextCase.getY()][nextCase.getX()] = board.getPieces()[currentPiece.getY()][currentPiece.getX()];
		board.getPieces()[currentPiece.getY()][currentPiece.getX()] = new Blank(Color.BLANK);	
	}
	
	public boolean isPosseded(Piece piece)
	{
		if(this.currentColor == piece.getColor())
			return true;
		return false;
	}
	
	public Point askPosition(Point p) throws PointException
	{
		Scanner s = new Scanner(System.in);
		try
		{
			p = new Point(s.nextInt(),s.nextInt());
			if(p.getX()<0 || p.getX()>7 || 
					p.getY()<0 || p.getY()>7)
			{
				throw new PointException();
			}
		}
		catch(InputMismatchException e)
		{
			s = new Scanner(System.in);
			System.out.println("RUDY");
		}
		
		return p;
	}
	
	public void newTurn()
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
		this.currentPiece = null;
		this.nextCase = null;
	}
	
	
	

}
