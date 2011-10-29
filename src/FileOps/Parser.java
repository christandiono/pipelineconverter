package FileOps;

import java.io.File;
import java.io.FileNotFoundException;


public interface Parser<T> {
	/**
	 * Parse the string of text to an object.
	 * @param fileToParse the string of text to convert.
	 * @return the parsed object.
	 */
	public T parse(String textToParse);
	/**
	 * Parse the passed in file to an object. If the file is not found,
	 * throws FileNotFoundException.
	 * @param fileToParse
	 * @return the parsed object.
	 * @throws FileNotFoundException thrown if the file specified does not exist.
	 */
	public T parse(File fileToParse) throws FileNotFoundException;
}
