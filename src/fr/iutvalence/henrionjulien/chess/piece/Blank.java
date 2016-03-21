package fr.iutvalence.henrionjulien.chess.piece;
/**
 * this class is use in order to  simulate a blank case of the board.
 * @author henrionj
 *
 */
public class Blank extends Piece {
	
	public Blank(Color color)
	{
		super(color);
	}
	
	@Override
	protected int[][] createMove() {
		return new int[0][0];
	}

}
