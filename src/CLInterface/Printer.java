/**
 * 
 */
package CLInterface;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Quick and dirty Logger class that accepts messages to log and either logs them if possible, or else discards them 
 * @author Chris Tandiono
 */
public class Printer {
	
	/**
	 * Prints messages to destination.
	 * @param destination OutputStream to write to. If null, doesn't actually write anything to anywhere.
	 * @param messages Strings to write. Doesn't write null strings at all (as opposed to outputting a blank line, for example).
	 */
	private static void actuallyPrint(OutputStream destination, String[] messages) {
		if (destination == null) { /* no point actually doing anything */
			return;
		}
		String message;
		for (int i = 0; i < messages.length; i++) {
			message = messages[i];
			if (message != null) { /* null: ignore */
				try {
					destination.write(message.getBytes());
					destination.write("\n".getBytes());
					destination.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Print to System.err, if so defined on the command-line.
	 * 
	 * @param messages Message(s) to write.
	 */
	public static void log(String... messages) {
		actuallyPrint(ConverterConfig.DEBUG, messages);
	}
	
	/**
	 * Print to output as configured on the command-line.
	 * 
	 * @param messages Message(s) to write.
	 */
	public static void output(String... messages) {
		actuallyPrint(ConverterConfig.OUTPUT, messages);
	}
	
	/**
	 * Print with custom OutputStream destination.
	 * 
	 * @param destination OutputStream to write to.
	 * @param messages Message(s) to write.
	 */
	public static void output(OutputStream destination, String... messages) {
		actuallyPrint(destination, messages);
	}
	
}
