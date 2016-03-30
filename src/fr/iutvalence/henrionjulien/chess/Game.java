package fr.iutvalence.henrionjulien.chess;

import java.util.Scanner;

import fr.iutvalence.henrionjulien.chess.piece.Color;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Game
{
	/** TODO. */
	/* TODO final? */
	private Board board;
	/** TODO. */
	/* TODO final? */
	private Player white;
	/** TODO. */
	/* TODO final? */
	private Player black;
	/** TODO. */
	private int turn;

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
		int x
		    ,y;
		
		/*System.out.println("\n\n\n                            					******game is already running******");
		Scanner s = new Scanner(System.in);
		System.out.println("donnez la position x:");
		x = s.nextInt();
		System.out.println("donnez la position y:");
		y = s.nextInt();
		s.close();*/
		if(board.isEatable(board.getPieces()[0][0], board.getPieces()[7][0]))
			System.out.println("\nmichou ça se mange");
		else System.out.println("michou c'est pas comestible");
		
	}

}
