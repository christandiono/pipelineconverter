package CLInterface;
import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * PipelineConverter main class. Contains main method for converter program.
 * 
 * Help is provided by supplying the -h or --help options.
 * 
 * @author Chris Tandiono
 */
public class PipelineConverter {

	public static void main(String[] args) {
		Options options = makeOptions();
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			printHelp(options);
			System.exit(0);
		}
		
		
		if (cmd.hasOption('v')) {
			ConverterConfig.VERBOSE = true;
			ConverterConfig.DEBUG = System.err;
			Printer.log("OK, going to be very verbose...");
		}
		
		if (cmd.hasOption('f')) {
			ConverterConfig.FORCE = true;
			Printer.log("OK, forcing conversion...");			
		}

		
		String inputFileName = cmd.getOptionValue('i');
		File inputFile = new File(inputFileName);

		if (inputFile.isDirectory()) {
			throw new InvalidInputException("Don't specify directory, specify a file");
		}
		
		String inputExt = extractExt(inputFileName);
		ConverterConfig.INPUT_FORMAT = extToFormat(inputExt);
		Printer.log("Input format detected as: " + ConverterConfig.INPUT_FORMAT.toString());
		
		configureOutput(cmd);
		

	}
	
	/**
	 * Checks and configures output
	 * @param cmd The CommandLine object that's been parsed already
	 */
	static void configureOutput(CommandLine cmd) {
		// TODO Auto-generated method stub
		String outputFileName = cmd.getOptionValue('o');
		File outputFile = new File(outputFileName);
	}

	/**
	 * Converts an extension (without the period) to a Format
	 * 
	 * @param inputExt Extension (ga, t2flow, pipe)
	 * @return Format enum
	 */
	static Format extToFormat(String inputExt) {
		Format inputForm = null;
		if (inputExt.equals("ga")) {
			inputForm = Format.GALAXY;
        } else if (inputExt.equals("t2flow")) {
			inputForm = Format.TAVERNA;
        } else if (inputExt.equals("pipe")) {
			inputForm = Format.LONI;
        } else {
        	throw new InvalidInputException("Invalid file extension: " + inputExt);
        }
		
		return inputForm;
	}
	
	/**
	 * Returns the last extension of a filename, without the leading period. For example, foo.tar.gz's last extension is "gz".
	 * 
	 * @param inputFileName A file name to get the last extension of
	 * @return The last extension of the file
	 */
	static String extractExt(String inputFileName) {
		int lastDot = inputFileName.lastIndexOf(".");
		if (lastDot < 0) {
			throw new InvalidInputException("Filename does not have an extension");
		}
		String ext = inputFileName.substring(lastDot+1,inputFileName.length());
		return ext;
	}
	
	/**
	 * Set up the options for this program.
	 * 
	 * @return Options object with valid command-line arguments.
	 */
	static Options makeOptions() {
		Options options = new Options();
		
		Option toStdout = new Option("c", false, "print output to stdout instead of to file");
		
		Option force = new Option("f", "force", false, "force (attempt to ignore errors)");
		
		Option input = new Option("i", "input", true, "input file");
		input.setArgs(1);
		input.setRequired(true);
		
		Option output = new Option("o", "output", true, "output file (if --output-format not specified)");
		output.setArgs(1);
		
		Option outputFormat = new Option("p", "output-format", false, "output file format (if --output not specified)");
		outputFormat.setArgs(1);
		
		Option galaxyDir = new Option("g", "galaxy-app-dir", true, "input directory for Galaxy .xml files");
		galaxyDir.setArgs(1);
		
		Option galaxyOutputDir = new Option("j", "galaxy-output-app-dir", true, "output directory for Galaxy .xml files");
		galaxyOutputDir.setArgs(1);
		
		Option verbose = new Option("v", "verbose", false, "verbose");
		
		Option help = new Option("h", "help", false, "print this help");
		
		options.addOption(toStdout);
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
	
	/**	
	 * Convenience method for printing help.
	 * 
	 * @param options Options object to print.
	 */
	static void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java " + PipelineConverter.class.getSimpleName(), options, true);
	}
	
}
