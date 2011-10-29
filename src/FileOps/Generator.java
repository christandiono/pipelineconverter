package FileOps;

import java.io.IOException;

public interface Generator<T> {
	/**
	 * Converts the object to text and stores inside the file the variable
	 * path points to.
	 * @param object the object to parse.
	 * @param path the path of the file the textified object is stored in.
	 * @throws IOException thrown in object is not successfully written to file.
	 */
	public void generate(T object, String path) throws IOException;
	/**
	 * Converts the object to text, returned in a string.
	 * @param object the object to parse.
	 * @return the textified version of the object contained in a String.
	 */
	public String generate(T object);
}
