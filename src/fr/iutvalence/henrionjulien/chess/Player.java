package fr.iutvalence.henrionjulien.chess;

import fr.iutvalence.henrionjulien.chess.piece.Color;
import fr.iutvalence.henrionjulien.chess.piece.Piece;

/**
 * TODO.
 *
 * @author henrion & murer
 * @version TODO
 */
public class Player {
	private Color color;
	public Player(Color c)
	{
		this.color = c;
	}
	
	/**
	 * 
	 * @param piece the current piece
	 * @return true if the piece is posseded by the player, else false.
	 */
	public boolean posseded(Piece piece)
	{
		if(this.color == piece.getColor())
			return true;
		return false;
	}
}
