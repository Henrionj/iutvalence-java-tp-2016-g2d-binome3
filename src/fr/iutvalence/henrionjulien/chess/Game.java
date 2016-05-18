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
	/** Chessboard of the game. */

	private final Board board;
	


	/** current turn odd define the turn of the white player, even for the black. */
	private int turn = 1;
	/** TODO. */
	private Point currentPiece = null
				 ,nextCase = null;
	/** The current color's player of the turn */
	private Color currentColor;
	/**A scanner use to key in data from the keyboard.*/
	private boolean KingIsDead;
	

	/**
	 * Create a board
	 * the gamme is running while the 2 kings are alive
	 * The game begins with the player who plays the white pieces.
     */
	public Game()
	{
		this.board = new Board();
		this.KingIsDead = false;
		this.currentColor = Color.WHITE;
	}
/**
 * Run the game.
 */
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
								if(board.getPiece(nextCase).isKing())
									KingIsDead = true;
								board.eat(board.getPiece(nextCase));
								move(currentPiece,nextCase);
								this.promotePawn(nextCase);
								System.out.println("Déplacement effectué!");
								this.board.display();
								System.out.println("\n\n\n\n*********************************************************************************************");
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
	/**
	 * Exit the game.
	 */
	public void exit()
	{
		System.out.println("******exit******");
	}
	/**
	 * Allow the movement of one piece.
	 * @param currentPiece The piece selected by the player
	 * @param nextCase The next position of piece selected
	 */
	public void move(Point currentPiece, Point nextCase)
	{
		board.getPieces()[nextCase.getY()][nextCase.getX()] = board.getPieces()[currentPiece.getY()][currentPiece.getX()];
		board.getPieces()[currentPiece.getY()][currentPiece.getX()] = new Blank();	
	}
	/**
	 * Check if the piece if posseded by the player of the same colour.
	 * @param piece
	 * @return a boolean to know if the piece is posseded by the current player.
	 */
	public boolean isPosseded(Piece piece)
	{
		return (this.currentColor == piece.getColor());
	}
	/**
	 * Ask the position in the array  to do a  move.
	 * @param p The position we are looking for.
	 * @return p : The postion
	 * @throws PointException
	 */
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
			System.err.println("déplacement invalide.");			
		}
		
		
		return p;
	}
	/**
	 * 
	 * Start a new turn and add 1 to turn attribut
	 * The next player can perform an action.
	 */
	public void newTurn()
	{
		System.out.println("turn "+turn);
		this.board.display();
		
		/*
		 * change the color of the player in terms of the turn.
		 */
		this.currentColor = ((turn%2) == 0) ? Color.BLACK : Color.WHITE;
		
		/*
		 * Select the position of the choosenPiece
		 */
		this.currentPiece = null;
		this.nextCase = null;
	}
	
	/**
	 * When a pawn reach the last row, he can perform a promotion and choose among the piece in his own the cemetery
	 * @param current
	 */
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
			    System.out.println("Veuillez selectionner une pièce du cimetière. (un nombre est attendu)");
			    this.board.getPieces()[current.getY()][current.getX()] = this.board.getWhiteCemetery().get(s.nextInt());
			}
			if(this.board.getPiece(current).getColor() == Color.BLACK && this.board.getBlackCemetery().size()!=0)
			{
				   for(int i = 0; i < this.board.getBlackCemetery().size(); i++)
				    {
				      System.out.println(i + ".  " + this.board.getBlackCemetery().get(i).toString());
				      System.out.println("Veuillez selectionner une pièce du cimetière. (un nombre est attendu)");
				      this.board.getPieces()[current.getY()][current.getX()] = this.board.getBlackCemetery().get(s.nextInt());
				    }  
			}
		}
	}
	/**
	 * realize the castling action if every conditions have been fullfilled. 
	 * @return <tt>true</tt> if the castling have been done, <tt>false</tt> if not.
	 */
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
