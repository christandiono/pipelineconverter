import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class PipelineConverter {

	public static void main(String[] args) {
		Options options = makeOptions();
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			printHelp(options);
			System.exit(-1); /* error */
		}
		
		if (cmd.hasOption('h')) {
			printHelp(options);
			System.exit(0);
		}
		
		if (cmd.hasOption('f')) {
			System.out.println("OK, forcing conversion...");
			ConverterConfig.FORCE = true;
		}
		
		String inputFileName = cmd.getOptionValue('i');
		String outputFileName = cmd.getOptionValue('o');
		
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		if (inputFile.isDirectory() || outputFile.isDirectory()) {
			System.err.println("Don't specify directory, specify a file");
			System.exit(-1);
		}
		
		String inputExt = extractExt(inputFileName);
		Format inputForm = extToFormat(inputExt);
	}
	
	/**
	 * @param inputExt Extension (.ga, .t2flow, .pipe)
	 * @return Format enum
	 */
	private static Format extToFormat(String inputExt) {
		Format inputForm = null;
		if (inputExt.equals("ga")) {
			// TODO galaxy
			inputForm = Format.GALAXY;
        } else if (inputExt.equals("t2flow")) {
			// TODO taverna
			inputForm = Format.TAVERNA;
        } else if (inputExt.equals("pipe")) {
			// TODO loni
			inputForm = Format.LONI;
        } else {
			System.err.println("Invalid input file extension.");
			System.exit(-1);
        }
		
		return inputForm;
	}
	
	/**
	 * @param inputFileName A file name to get the last extension of
	 * @return The last extension of the file
	 */
	private static String extractExt(String inputFileName) {
		int lastDot = inputFileName.lastIndexOf(".");
		String ext = inputFileName.substring(lastDot+1,inputFileName.length());
		return ext;
	}
	
	/**
	 * @return Options object with valid command-line arguments.
	 */
	private static Options makeOptions() {
		Options options = new Options();
		
		Option force = new Option("f", "force", false, "force (attempt to ignore errors)");
		
		Option input = new Option("i", "input", true, "input file");
		input.setArgs(1);
		input.setRequired(true);
		
		Option output = new Option("o", "output", true, "output file (if --output-format not specified)");
		output.setArgs(1);
		
		Option outputFormat = new Option("k", "output-format", false, "output file format (if --output not specified)");
		outputFormat.setArgs(1);
		
		Option galaxyDir = new Option("g", "galaxy-app-dir", true, "input directory for Galaxy .xml files");
		galaxyDir.setArgs(1);
		
		Option galaxyOutputDir = new Option("j", "galaxy-output-app-dir", true, "output directory for Galaxy .xml files");
		galaxyOutputDir.setArgs(1);
		
		Option verbose = new Option("v", "verbose", false, "verbose");
		
		Option help = new Option("h", "help", false, "print this help");
		
		options.addOption(force);
		options.addOption(input);
		options.addOption(output);
		options.addOption(outputFormat);
		options.addOption(galaxyDir);
		options.addOption(galaxyOutputDir);
		options.addOption(verbose);
		options.addOption(help);
		return options;
	}
	
	private static void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java " + PipelineConverter.class.getName(), options, true);
	}
	
}
