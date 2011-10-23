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
	
	private static void actuallyPrint(String[] messages, OutputStream destination) {
		String message;
		for (int i = 0; i < messages.length; i++) {
			message = messages[i];
			if (destination != null && message != null) {
				try {
					destination.write(message.getBytes());
					destination.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void log(String... messages) {
		actuallyPrint(messages, ConverterConfig.DEBUG);
	}
	
	public static void output(String... messages) {
		actuallyPrint(messages, ConverterConfig.OUTPUT);
	}
	
}
