package fr.iutvalence.henrionjulien.chess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.NoMoveException;
import fr.iutvalence.henrionjulien.chess.piece.Rook;

/**
 * The game class
 * contains the rules of a basic chess game.
 *
 * @author henrion & murer
 * @version V1
 */
public class Game
{
	/** Chessboard of the game. */
	private final Board board;
	/**A scanner use to key in data from the keyboard.*/
	private final Scanner s;
	/** current turn odd define the turn of the white player, even for the black. */
	private int turn = 1;
	/** Name of the player 1 */
	private String player1;
	/** Name of the player 2 */
	private String player2;
	
	
	 private FileOutputStream fileWriter = null;
	 private FileInputStream fileReader = null;
	 


	/**
	 * Create a board
	 * the game is running while the 2 kings are alive
	 * The game begins with the player who plays the white pieces.(Player 1)
	 */
	public Game(String p1, String p2, Scanner scanner)
	{
		this.board = new Board();
		this.s = scanner;
		this.player1 = p1;
		this.player2 = p2;
		  try 
			{
			    fileReader = new FileInputStream(new File("chessSave.txt"));
				this.readSave();
			    fileWriter = new FileOutputStream(new File("chessSave.txt"));
			} catch (FileNotFoundException e) 
			{
				System.out.println("File not found.");
				e.printStackTrace();
			}
	}
	/**
	 * Run the game.
	 */
	public void run()
	{	
		char[] save = new char[7];
		Color currentColor = Color.WHITE;
		boolean kingIsDead = false;
		System.out.println("******game is already running******");
		while(!kingIsDead)
		{
			Point currentPiece = null;
			currentColor = this.newTurn();
			if((currentColor) == Color.WHITE)
				save[0] = 'W';
			else
				save[0] = 'B';
			if(this.castLing())
				continue;
			while(currentPiece == null)
			{
				currentPiece = null;
				System.out.println("\ndonnez la position x,puis la position y de la piece:");	
				try 
				{
					currentPiece = this.askPosition(currentPiece);
					save[1] = currentPiece.getCharX();
					save[2] = currentPiece.getCharY();
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
			if(this.board.getPiece(currentPiece).getColor() == currentColor)
			{
				Point nextCase = null;
				System.out.println(this.board.getPiece(currentPiece).toString());
				while(nextCase == null)
				{
					System.out.println("donnez la position x,puis la position y du déplacement:");
					try 
					{
						nextCase = this.askPosition(nextCase);
					}
					catch (PointException e)
					{
						System.out.println("Coordonnées invalides, veuillez saisir un chiffre entre 0 et 7 pour x et y.");
						nextCase = null;
					}
				}
				/*
				 * check if the piece of the next move is "eatable" (different color or blank)
				 * and put her in the cemetery
				 */
				try {
					if(this.board.getPiece(currentPiece).moveIsPossible(currentPiece, nextCase, board.getPieces()))
					{
						if (this.board.isEatable(currentPiece, nextCase)) {
							if(board.getPiece(nextCase).isKing())
								kingIsDead = true;
							board.eat(board.getPiece(nextCase));
							board.move(currentPiece,nextCase);
							save[3] = 'M';
							if(this.board.getPiece(nextCase).getColor()!= this.board.getPiece(currentPiece).getColor() && this.board.getPiece(nextCase).getColor() != Color.BLANK)
							{
								save[4] = 'E';
							}
							else
							{
								save[4] = 'M';
							}
							save[5] = nextCase.getCharX();
							save[6] = nextCase.getCharY();
							this.promotePawn(nextCase);
							System.out.println("Déplacement effectué!");
							this.board.display();
							System.out.println("\n\n\n\n*********************************************************************************************");
							turn++;	
							board.invertBoard();
							this.writeTurn(save);
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
		System.out.printf("Les %s gagnent", currentColor == Color.WHITE ? "Blancs" : "Noirs");

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
	 * Ask the position in the array  to do a  move.
	 * @param p The position we are looking for.
	 * @return p : The postion
	 * @throws PointException
	 */
	public Point askPosition(Point p) throws PointException
	{
		try
		{
			p = new Point(s.nextInt(),s.nextInt());
			if(p.getX()<0 || p.getX()>7 || 
					p.getY()<0 || p.getY()>7)
			{
				throw new PointException("coordonnée invalide");
			}
		}
		catch(InputMismatchException e)
		{
			throw new PointException("déplacement invalide.", e);			
		}


		return p;
	}
	/**
	 * 
	 * Start a new turn and add 1 to the turn attribut
	 * The next player can perform an action.
	 */
	public Color newTurn()
	{
		System.out.println("turn "+turn + "\t"+ (((turn%2) == 0) ? this.player2 : this.player1));
		this.board.display();

		/*
		 * change the color of the player in terms of the turn.
		 */
		return  ((turn%2) == 0) ? Color.BLACK : Color.WHITE;

	}

	/**
	 * When a pawn reach the last row, he can perform a promotion and choose among the piece in his own cemetery
	 * @param current
	 */
	public void promotePawn(Point current)
	{
		if (current.getY() == 0 && this.board.getPiece(current).isPawn())
		{
			if(this.board.getPiece(current).getColor() == Color.WHITE && this.board.getWhiteCemetery().size()!=0)
			{
				for(int i = 0; i < this.board.getWhiteCemetery().size(); i++)
				{
					System.out.println(i + ".  " + this.board.getWhiteCemetery().get(i).toString());
				}  
				System.out.println("Veuillez selectionner une pièce du cimetière. (un nombre est attendu)");
				board.promote(s.nextInt(), current, Color.WHITE);
			}
			if(this.board.getPiece(current).getColor() == Color.BLACK && this.board.getBlackCemetery().size()!=0)
			{
				for(int i = 0; i < this.board.getBlackCemetery().size(); i++)
				{
					System.out.println(i + ".  " + this.board.getBlackCemetery().get(i).toString());
					System.out.println("Veuillez selectionner une pièce du cimetière. (un nombre est attendu)");
					board.promote(s.nextInt(), current, Color.BLACK);
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
		for(int i = 0;i<8;i++)
		{
			if(this.board.getPiece(new Point(i,7)).isKing())
			{
				if(this.board.getPiece(new Point(i,7)).isMoved())
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
				board.moveKing(new Point(kingX,7));
				switch(sizeLeftCastling)
				{
				case 2:
					board.move(new Point(kingX,7),new Point(1,7));
					board.move(new Point(0,7),new Point(2,7));
					break;
				case 3:
					board.move(new Point(kingX,7),new Point(2,7));
					board.move(new Point(0,7),new Point(3,7));
					break;

				}
			}
			if(answer == 0)
			{
				board.moveKing(new Point(kingX,7));
				switch(sizeRightCastling)
				{
				case 2:
					board.move(new Point(kingX,7),new Point(6,7));
					board.move(new Point(0,7),new Point(5,7));
					break;
				case 3:
					board.move(new Point(kingX,7),new Point(5,7));
					board.move(new Point(0,7),new Point(4,7));
					break;

				}
			}


		}

		if(leftCastling && !rightCastling)
		{
			board.moveKing(new Point(kingX,7));
			switch(sizeLeftCastling)
			{
			case 2:
				board.move(new Point(kingX,7),new Point(1,7));
				board.move(new Point(0,7),new Point(2,7));
				break;
			case 3:
				board.move(new Point(kingX,7),new Point(2,7));
				board.move(new Point(0,7),new Point(3,7));
				break;

			}
		}

		if(!leftCastling && rightCastling)
		{
			board.moveKing(new Point(kingX,7));
			switch(sizeRightCastling)
			{
			case 2:
				board.move(new Point(kingX,7),new Point(6,7));
				board.move(new Point(0,7),new Point(5,7));
				break;
			case 3:
				board.move(new Point(kingX,7),new Point(5,7));
				board.move(new Point(0,7),new Point(4,7));
				break;
			}
		}


		this.turn++;	
		board.invertBoard();
		return true;
	}
	
	 public void writeTurn(char turnSave[])
	 {
		 	byte[] endLine = {10};
			byte[] save = new byte[7];
			int indice = 0;
		      for (char ch : turnSave)
		      {
		    	 
		    	  save[indice] = (byte)ch;
		    	  indice++;
		      }
		      try 
		      {
				  fileWriter.write(save);
				  fileWriter.write(endLine);
					      
		      
		      } catch (IOException e) 
		      {
				  e.printStackTrace();
			  }	    
	 }
	 
	  
	 public void readSave()
	 {
		 Point currentPiece;
		 Point nextCase;
		 byte[] save = new byte[7];
		 int end = 0;
		 try {
			while ( end != -1) 
			{
				System.out.println(end);
				end = fileReader.read(save);
				currentPiece = new Point((int)save[1]-48,(int)save[2]-48);
		    	nextCase = new Point((int)save[5]-48,(int)save[6]-48);
			    switch(save[3])
			    {
				    case (byte)'M':
				    	board.eat(board.getPiece(nextCase));
						board.move(currentPiece,nextCase);
						this.board.display();
						System.out.println("\n\n\n\n*********************************************************************************************");
						turn++;	
						board.invertBoard();
				    	break;
				    case (byte)'P':
				    	break;
				    case (byte)'C':
				    	break;
			    }
		            
			    save = new byte[7];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }



}
