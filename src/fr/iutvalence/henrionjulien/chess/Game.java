package fr.iutvalence.henrionjulien.chess;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Game
{
	private Board board;
	private Player white;
	private Player black;
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
		
	}
	
}
