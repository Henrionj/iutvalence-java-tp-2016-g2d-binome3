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
	private int turn;
	/** TODO. */
	private Point currentPiece
				 ,nextCase;
	

	/**
	 * TODO.
     */
	public Game()
	{
		this.black = new Player(Color.BLACK);
		this.white = new Player(Color.WHITE);
		this.board = new Board();
	}

	public void run()
	{	
		System.out.println("\n\n\n                            					******game is already running******");
		Scanner s = new Scanner(System.in);
		System.out.println("donnez la position x,puis la position y de la piece:");
		currentPiece = new Point(s.nextInt(),s.nextInt());
		System.out.println(board.getPieces()[currentPiece.getY()][currentPiece.getX()].toString());
		System.out.println("donnez la position x,puis la position y du déplacement:");
		s.close();
		turn++;
	}
	
	public void move(Piece currentPiece,Piece nextCase, int x, int y)
	{
	
		
	}

}
