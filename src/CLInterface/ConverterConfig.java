package CLInterface;

import java.io.OutputStream;

/**
 * ConverterConfig class. Only contains static variables for configuration of this conversion session.
 */

/**
 * ConverterConfig class.
 * 
 * @author Chris Tandiono
 *
 */
public class ConverterConfig {

	/**
	 * Whether to attempt to ignore errors and force conversion
	 */
	public static boolean FORCE = false;

	/**
	 * Where to send debug messages
	 */
	public static OutputStream DEBUG = null;

	/**
	 * Where to send output (the converted file)
	 */
	public static OutputStream OUTPUT = null;

	/**
	 * The format of the input file
	 */
	public static Format INPUT_FORMAT = null;

	/**
	 * The format of the output file
	 */
	public static Format OUTPUT_FORMAT = null;

	/**
	 * Path to input file. Necessary because FileInputStream doesn't offer a way to retrieve file name.
	 */
	public static String INPUT_PATH = null;

	/**
	 * Path to output file (may be dynamically generated). Necessary because FileOutputStream doesn't offer a way to retrieve file name.
	 */
	public static String OUTPUT_PATH = null;

	/**
	 * Path to find Galaxy .xml files, if necessary
	 */
	public static Object GALAXY_INPUT_DIR = null;

	/**
	 * Path to place Galaxy .xml files, if necessary
	 */
	public static String GALAXY_OUTPUT_DIR = null;

	/**
	 * Convenience method for resetting configuration (as needed in the tests)
	 */
	static void reset() {
		FORCE = false;
		DEBUG = null;
		OUTPUT = null;
		INPUT_FORMAT = null;
		OUTPUT_FORMAT = null;
		INPUT_PATH = null;
		OUTPUT_PATH = null;
		GALAXY_INPUT_DIR = null;
		GALAXY_OUTPUT_DIR = null;
	}

}
