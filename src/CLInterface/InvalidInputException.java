package CLInterface;

/**
 * A generic class for invalid input.
 * @author Chris Tandiono
 */
public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 5660148534844302671L;
	private String string;

	/**
	 * Default constructor. Accepts a string which will be printed out when the program exits.
	 *
	 * @param string
	 */
	public InvalidInputException(String string) {
		this.string = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return this.string;
	}

}
