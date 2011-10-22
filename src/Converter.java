import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Converter {
	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("f", false, "force conversion");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("You did a bad.");
			System.exit(-1);
		}
		if (cmd.hasOption("f")) {
			System.out.println("OK, forcing conversion...");
		}
	}
}
