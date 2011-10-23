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
	 * Whether we should spit out a lot of messages
	 */
	public static boolean VERBOSE = false;

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
	 * Path to input file
	 */
	public static String INPUT_PATH = null;
	
	/**
	 * Path to output file (may be dynamically generated)
	 */
	public static String OUTPUT_PATH = null;
	
	/**
	 * Path to place Galaxy .xml files, if necessary
	 */
	public static String GALAXY_OUTPUT_DIR = null;

	/**
	 * Path to find Galaxy .xml files, if necessary
	 */
	public static Object GALAXY_INPUT_DIR = null;
	
}
