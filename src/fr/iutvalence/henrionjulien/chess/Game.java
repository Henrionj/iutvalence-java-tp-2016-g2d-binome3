package fr.iutvalence.henrionjulien.chess;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Blank;
import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.King;
import fr.iutvalence.henrionjulien.chess.piece.NoMoveException;
import fr.iutvalence.henrionjulien.chess.piece.Piece;
import fr.iutvalence.henrionjulien.chess.piece.Rook;

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
 			if(this.castLing())
 				continue;
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
						System.out.println("Coordonn�es invalides, veuillez saisir un chiffre entre 0 et 7 pour x et y.");
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
					System.out.println("donnez la position x,puis la position y du d�placement:");
					try 
						{
						this.nextCase = this.askPosition(this.nextCase);
						}
					catch (PointException e)
						{
							System.out.println("Coordonn�es invalides, veuillez saisir un chiffre entre 0 et 7 pour x et y.");
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
								if(board.getPiece(nextCase).isKing())
									KingIsDead = true;
								board.eat(board.getPiece(nextCase));
								move(currentPiece,nextCase);
								this.promotePawn(nextCase);
								System.out.println("D�placement effectu�!");
								this.board.display();
								System.out.println("\n\n\n\n*********************************************************************************************");
								turn++;	
								board.invertBoard();
							}
							else
							{
								System.out.println("Mouvement non autoris�, la case contient une autre pi�ce de m�me couleur.");
							}
							
						}
					else
					{
						System.out.println("mouvement non autoris�, la pi�ce ne peut faire un tel mouvement.");
					}
				} catch (NoMoveException e) {
					System.out.println("Vous ne pouvez pas d�placer la pi�ce sur elle m�me!");
				}
				
			}
			
			else
			{
				System.out.println("Vous ne poss�dez pas cette piece!");
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
			System.out.println("d�placement invalide.");
			
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
	
	public void promotePawn(Point current)
	{
		Scanner s = new Scanner(System.in);
		if (current.getY() == 0 && this.board.getPiece(current).isPawn())
		{
			if(this.board.getPiece(current).getColor() == Color.WHITE && this.board.getWhiteCemetery().size()!=0)
			{
			    for(int i = 0; i < this.board.getWhiteCemetery().size(); i++)
			    {
			      System.out.println(i + ".  " + this.board.getWhiteCemetery().get(i).toString());
			    }  
			    System.out.println("Veuillez selectionner une pi�ce du cimeti�re. (un nombre est attendu)");
			    this.board.getPieces()[current.getY()][current.getX()] = this.board.getWhiteCemetery().get(s.nextInt());
			}
			if(this.board.getPiece(current).getColor() == Color.BLACK && this.board.getBlackCemetery().size()!=0)
			{
				   for(int i = 0; i < this.board.getBlackCemetery().size(); i++)
				    {
				      System.out.println(i + ".  " + this.board.getBlackCemetery().get(i).toString());
				      System.out.println("Veuillez selectionner une pi�ce du cimeti�re. (un nombre est attendu)");
				      this.board.getPieces()[current.getY()][current.getX()] = this.board.getBlackCemetery().get(s.nextInt());
				    }  
			}
		}
	}

	public boolean castLing()
	{
		Rook rook;
		int kingX = 0;
		int sizeLeftCastling = 0,
			sizeRightCastling = 0;
		boolean leftCastling = true,
				rightCastling = true;
		Scanner s = new Scanner(System.in);
		for(int i = 0;i<8;i++)
		{
			if(this.board.getPiece(new Point(i,7)).isKing())
			{
				if(board.getPieces()[7][i].isMoved())
				{
					return false;
				}
				kingX = i;
			    for(i = kingX;i<8;i++)
			    {
			    	if(this.board.getPiece(new Point(i,7)).isRook())
					{
						rook = (Rook)this.board.getPiece(new Point(i,7));
						if(rook.isMoved())
						{
							return false;
						}
						for(i = 1;i<kingX;i++)
						{
							if(this.board.getPiece(new Point(i,7)).getColor() != Color.BLANK)
								leftCastling = false;
							sizeLeftCastling++;
						}
						for(i = kingX+1;i<7;i++)
						{
							if(this.board.getPiece(new Point(i,7)).getColor() != Color.BLANK)
								rightCastling = false;
							sizeRightCastling++;
						}
			        }
				}
				
			}
			
		}
		if(!leftCastling && !rightCastling)
			return false;
		System.out.println("\nRoque possible, voulez vous en effectuer un? 0 = oui/1 = non");
		if(s.nextInt() == 1)
			return false;
		System.out.println("left = "+sizeLeftCastling + " right = " + sizeRightCastling);
		if(leftCastling && rightCastling)
		{
			int answer = -1;
			System.out.println("deux roques possibles, voulez vous effectuer un roque par la droite ou par la gauche?"
					+ "\n 0 = Droite / 1 = Gauche");
			answer = s.nextInt();
			if(answer == 1)
			{
				board.getPieces()[7][kingX].Moved();
				switch(sizeLeftCastling)
				{
				case 2:
					move(new Point(kingX,7),new Point(1,7));
					move(new Point(0,7),new Point(2,7));
				break;
				case 3:
					move(new Point(kingX,7),new Point(2,7));
					move(new Point(0,7),new Point(3,7));
				break;
				
				}
			}
			if(answer == 0)
			{
				board.getPieces()[7][kingX].Moved();
				switch(sizeRightCastling)
				{
				case 2:
					move(new Point(kingX,7),new Point(6,7));
					move(new Point(0,7),new Point(5,7));
				break;
				case 3:
					move(new Point(kingX,7),new Point(5,7));
					move(new Point(0,7),new Point(4,7));
				break;
				
				}
			}
			
			
		}
		
		if(leftCastling && !rightCastling)
		{
			board.getPieces()[7][kingX].Moved();
			switch(sizeLeftCastling)
			{
			case 2:
				move(new Point(kingX,7),new Point(1,7));
				move(new Point(0,7),new Point(2,7));
			break;
			case 3:
				move(new Point(kingX,7),new Point(2,7));
				move(new Point(0,7),new Point(3,7));
			break;
			
			}
		}
		
		if(!leftCastling && rightCastling)
		{
			board.getPieces()[7][kingX].Moved();
			switch(sizeRightCastling)
			{
			case 2:
				move(new Point(kingX,7),new Point(6,7));
				move(new Point(0,7),new Point(5,7));
			break;
			case 3:
				move(new Point(kingX,7),new Point(5,7));
				move(new Point(0,7),new Point(4,7));
			break;
			}
		}
		
		
		this.turn++;	
		board.invertBoard();
		return true;
	}
	
	

}
