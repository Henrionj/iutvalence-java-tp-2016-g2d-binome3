package fr.iutvalence.henrionjulien.chess.piece;

/**
 * 
 * the type of color which is assign to the piece
 *
 */
public enum Color {

	BLACK("B "),
	WHITE("W "),
	BLANK("      _      ");
	
	private final String representation;
	
	Color(String repr) {
		this.representation = repr;
	}
	
	@Override
	public String toString() {
		return this.representation;
	}
}