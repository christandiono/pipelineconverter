/**
 * 
 */
package CLInterface;

/**
 * Quick and dirty Logger class that accepts messages to log and either logs them if possible, or else discards them 
 * @author Chris Tandiono
 */
public class Printer {
	
	public static void log(String message) {
		if (ConverterConfig.DEBUG != null && message != null) {
			ConverterConfig.DEBUG.println(message);
		}
	}
	
	public static void log(String... args) {
		for (int i = 0; i < args.length; i++) {
			log(args[i]);
		}
	}
	
	public static void output(String message) {
		if (ConverterConfig.OUTPUT != null && message != null) {
			ConverterConfig.OUTPUT.println(message);
		}
	}
	
	public static void output(String... args) {
		for (int i = 0; i < args.length; i++) {
			output(args[i]);
		}
	}
	
}
