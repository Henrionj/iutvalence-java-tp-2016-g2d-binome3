package fr.iutvalence.henrionjulien.chess;

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
		this.black = new Player();
		this.white = new Player();
		this.board = new Board();
	}

	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("game is already running");
	}

}
