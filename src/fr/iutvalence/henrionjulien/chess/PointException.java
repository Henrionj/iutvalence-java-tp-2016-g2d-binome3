package fr.iutvalence.henrionjulien.chess;
/**
 * Exception which happend when the point  is not a integer.
 * @author henrionj
 *
 */
public class PointException extends Exception {
	public PointException(String message, Throwable cause) {
		super(message, cause);
	}

	public PointException(String message) {
		super(message);
	}

}
