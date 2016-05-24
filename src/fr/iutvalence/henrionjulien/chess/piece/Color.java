package fr.iutvalence.henrionjulien.chess.piece;

/**
 * 
 * the type of color who can be assign to the piece
 *
 */
public enum Color {

	BLACK("B "),
	WHITE("W "),
	BLANK("|___________|");
	/**
	 * A representation of the color in String object.
	 */
	private final String representation;
	
	/**
	 * The color assigned for the piece.
	 * @param repr the representation of the color in String type.
	 */
	Color(String repr) {
		this.representation = repr;
	}
	
	@Override
	public String toString() {
		return this.representation;
	}
}
