import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class WorkflowConverter {
	public static void main(String[] args) {
		Options options = new Options();
		
		Option force = new Option("f", "force", false, "force (attempt to ignore errors)");
		
		Option input = new Option("i", "input", true, "input file");
		input.setArgs(1);
		input.setRequired(true);
		
		Option output = new Option("o", "output", true, "output file");
		output.setArgs(1);
		output.setRequired(true);
		
		Option galaxyDir = new Option("g", "galaxy-dir", true, "input directory for Galaxy .xml files");
		galaxyDir.setArgs(1);
		
		Option galaxyOutputDir = new Option("j", "galaxy-output-dir", true, "output directory for Galaxy .xml files");
		galaxyOutputDir.setArgs(1);
		
		Option verbose = new Option("v", "verbose", false, "verbose");
		
		Option help = new Option("h", "help", false, "print this help");
		
		options.addOption(force);
		options.addOption(input);
		options.addOption(output);
		options.addOption(galaxyDir);
		options.addOption(galaxyOutputDir);
		options.addOption(verbose);
		options.addOption(help);
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java Converter", options, true);
			System.exit(-1);
		}
		
		if (cmd.hasOption("f")) {
			System.out.println("OK, forcing conversion...");
		}
		String inputFile = cmd.getOptionValue('i');
		String outputFile = cmd.getOptionValue('o');

	}
}
