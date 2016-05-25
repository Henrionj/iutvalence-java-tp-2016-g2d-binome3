package fr.iutvalence.henrionjulien.chess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.NoMoveException;
import fr.iutvalence.henrionjulien.chess.piece.Rook;

/**
 * The game class
 * contains the rules of a basic chess game.
 *
 * @author Henrion & Murer
 * @version V1
 */
public class Game
{
	/** Chessboard of the game. */
	private final Board board;
	/**A scanner use to key in data from the keyboard.*/
	private Scanner s;
	/** current turn odd define the turn of the white player, even for the black. */
	private int turn = 1;
	/** Name of the player 1 */
	private String player1;
	/** Name of the player 2 */
	private String player2;
	
	
	 private FileOutputStream fileWriter = null;
	 private FileInputStream fileReader = null;
	 private File file = new File("chessSave.txt");
	 private List<byte[]> save;
	 


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
		this.save = new ArrayList<byte[]>();
		  try 
			{
			    fileReader = new FileInputStream(file);
				if(file.length() != 0)
				{
				    System.out.println("Would you like to load the last save?0 = yes/1 = no");
				    char ans = s.nextLine().charAt(0);
				    if(ans == '0')
				    {
				    	 this.readSave();
				    	 fileWriter = new FileOutputStream(file);
						 this.backUp();
				    }
				    if(ans != '0')
				    {
				    	 fileWriter = new FileOutputStream(file);
				    }
			    }
				else
				{
					fileWriter = new FileOutputStream(file);
				}
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
				System.out.println("\nKey in the  x position,then the y position of the piece:");	
				try 
				{
					currentPiece = this.askPosition(currentPiece);
					save[1] = currentPiece.getCharX();
					save[2] = currentPiece.getCharY();
				}
				catch (PointException e)
				{
					System.out.println("positions invalid,please key in a number between 0 and 7 for x and y.");
					s = new Scanner(System.in);
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
					System.out.println("key in x position,then y position");
					try 
					{
						nextCase = this.askPosition(nextCase);
					}
					catch (PointException e)
					{
						System.out.println("positions invalid,please key in a number between 0 and 7 for x and y.");
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
							System.out.println("Done!");
							this.board.display();
							System.out.println("\n\n\n\n*********************************************************************************************");
							turn++;	
							board.invertBoard();
							this.writeTurn(save);
						}
						else
						{
							System.err.println("move invalid, you can't eat your own piece.");
						}

					}
					else
					{
						System.out.println("move invalid, the piece can't do this.");
					}
				} catch (NoMoveException e) {
					System.out.println("you can't move your piece on the same position");
				}

			}

			else
			{
				System.out.println("You don't own this piece");
			}
		}
		System.out.printf(" %s win", currentColor == Color.WHITE ? "Whites" : "Blacks");

		this.exit();

	}
	/**
	 * Exit the game.
	 */
	public void exit()
	{
		System.out.println("******exit******");
		s.close();
		try {
			fileReader.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				throw new PointException("invalid coordonates");
			}
		}
		catch(InputMismatchException e)
		{
			throw new PointException("move invalid.", e);			
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
		System.out.println("\n one castling possible, would you like to do one? 0 = yes/1 = no");
		if(s.nextInt() == 1)
			return false;
		System.out.println("left = "+sizeLeftCastling + " right = " + sizeRightCastling);
		Point kingPosition = new Point(kingX,7);
		if(leftCastling && rightCastling)
		{
			int answer = -1;
			System.out.println("Two castlings are possible, Would you like to do a castling  to the right or to the left ?"
					+ "\n 0 = Right / 1 = Left");
			answer = s.nextInt();
			if(answer == 1)
			{
				board.moveKing(new Point(kingX,7));
				switch(sizeLeftCastling)
				{
				case 2:
					board.move(kingPosition,new Point(1,7));
					char[]kBigL = {'K','0','7','C','E','1','7'};
					kBigL[1] = kingPosition.getCharX();
					this.writeTurn(kBigL);
					board.move(new Point(0,7),new Point(2,7));
					char[]rBigL = {'R','0','7','C','G','2','7'};
					this.writeTurn(rBigL);
					break;
				case 3:
					board.move(new Point(kingX,7),new Point(2,7));
					char[]kLittleL = {'K','0','7','C','E','2','7'};
					kLittleL[1] = kingPosition.getCharX();
					this.writeTurn(kLittleL);
					board.move(new Point(0,7),new Point(3,7));
					char[]rLittleL = {'R','0','7','C','G','3','7'};
					this.writeTurn(rLittleL);
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
					char[]kBigR = {'K','0','7','C','E','6','7'};
					kBigR[1] = kingPosition.getCharX();
					this.writeTurn(kBigR);
					board.move(new Point(7,7),new Point(5,7));
					char[]rBigR = {'R','7','7','C','G','5','7'};
					this.writeTurn(rBigR);
					break;
				case 3:
					board.move(new Point(kingX,7),new Point(5,7));
					char[]kLittleR = {'K','0','7','C','E','5','7'};
					kLittleR[1] = kingPosition.getCharX();
					this.writeTurn(kLittleR);
					board.move(new Point(7,7),new Point(4,7));
					char[]rLittleR = {'R','7','7','C','G','4','7'};
					this.writeTurn(rLittleR);
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
				board.move(kingPosition,new Point(1,7));
				char[]kBigL = {'K','0','7','C','E','1','7'};
				kBigL[1] = kingPosition.getCharX();
				this.writeTurn(kBigL);
				board.move(new Point(0,7),new Point(2,7));
				char[]rBigL = {'R','0','7','C','G','2','7'};
				this.writeTurn(rBigL);
				break;
			case 3:
				board.move(new Point(kingX,7),new Point(2,7));
				char[]kLittleL = {'K','0','7','C','E','2','7'};
				kLittleL[1] = kingPosition.getCharX();
				this.writeTurn(kLittleL);
				board.move(new Point(0,7),new Point(3,7));
				char[]rLittleL = {'R','0','7','C','G','3','7'};
				this.writeTurn(rLittleL);
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
				char[]kBigR = {'K','0','7','C','E','6','7'};
				kBigR[1] = kingPosition.getCharX();
				this.writeTurn(kBigR);
				board.move(new Point(7,7),new Point(5,7));
				char[]rBigR = {'R','7','7','C','G','5','7'};
				this.writeTurn(rBigR);
				break;
			case 3:
				board.move(new Point(kingX,7),new Point(5,7));
				char[]kLittleR = {'K','0','7','C','E','5','7'};
				kLittleR[1] = kingPosition.getCharX();
				this.writeTurn(kLittleR);
				board.move(new Point(7,7),new Point(4,7));
				char[]rLittleR = {'R','7','7','C','G','4','7'};
				this.writeTurn(rLittleR);
				break;
			}
		}


		this.turn++;	
		board.invertBoard();
		return true;
	}
	/**
	 * Write the save into the document chessSave.txt
	 * The document is write with bytes.
	 * @param turnSave Save the data of the turn played into the saveChess.txt
	 */
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
	 
	  /**
	   * Read the save each time the  game is launch.
	   */
	 public void readSave()
	 {
		 Point currentPiece;
		 Point nextCase;
		 byte[] line = new byte[8];
		 int end = 0;
		 try {
			end = fileReader.read(line);
			while ( end != -1)// && fileReader.available() > 0) 
			{
				
				currentPiece = new Point((int)line[1]-48,(int)line[2]-48);
		    	nextCase = new Point((int)line[5]-48,(int)line[6]-48);
		    	
				board.eat(board.getPiece(nextCase));
			    board.move(currentPiece,nextCase);
			    this.board.display();
			    System.out.println("\n\n\n\n*********************************************************************************************");
			   if((byte)line[4] ==(byte)'G')
				   board.invertBoard();
			    
			    turn++;	
			    board.invertBoard();

			    
			    
		        this.save.add(line);   
			    line = new byte[8];
				end = fileReader.read(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 /**
	  * Store the previous save in order to be used the next time the game is launch.
	  */
	 public void backUp()
	 {
		    
			byte[] line = new byte[8];
			line[7] = 10;
			
			int indice = 0;
			for(int i = 0;i<this.save.size();i++)
			{ 
			for (byte b : this.save.get(i))
		     {
		    	 
		    	  line[indice] = (byte)b;
		    	  indice++;
		      }
			
		      try 
		      {
				  fileWriter.write(line);
					      
		      
		      } catch (IOException e) 
		      {
				  e.printStackTrace();
			  }	 
		      line = new byte[8];
		      indice = 0;
			}
	 }



}
