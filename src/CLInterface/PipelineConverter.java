package CLInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import org.apache.commons.io.FilenameUtils;

import Galaxy.Tree.Workflow.Workflow;
import Specification.GalaxySpecification;

/**
 * PipelineConverter main class. Contains main method for converter program.
 *
 * Help is provided by supplying the -h or --help options.
 *
 * @author Chris Tandiono
 */
public class PipelineConverter {

	public static void main(String[] args) throws IOException {
		Options options = makeOptions();

		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			printHelp(options);
			System.exit(0);
		}

		configureSpecial(cmd);

		configureInput(cmd);

		configureOutput(cmd);

		Printer.log("Done processing command-line arguments");

		if (ConverterConfig.OUTPUT == null && ConverterConfig.OUTPUT_PATH != null) {
			File output = new File(ConverterConfig.OUTPUT_PATH);
			output.createNewFile();
			try {
				ConverterConfig.OUTPUT = new FileOutputStream(output);
			} catch (FileNotFoundException e) {
				/* how would this have happened...? */
				Printer.log("Got a weird error: " + e.getMessage());
			}
		}

		Workflow g = null;
		if (ConverterConfig.INPUT_FORMAT == Format.GALAXY) {
			try {
				g = GalaxySpecification.getJSONParser().parse(new File(ConverterConfig.INPUT_PATH));
			} catch (FileNotFoundException e) {
				Printer.log("What, FileNotFoundException not caught by configureInput?");
			}
		} else {
			Printer.log("Well, I tried, but I can't understand your input");
		}

		String outputString = null;

		if (ConverterConfig.OUTPUT_FORMAT == Format.GALAXY) {
			outputString = GalaxySpecification.getJSONGenerator().generate(g);

		} else {
			Printer.log("Well, I tried, but I don't know how to make that kind of a file");
		}

		if (outputString != null) {
			Printer.output(outputString);
		}

		if (ConverterConfig.OUTPUT != null) {
			ConverterConfig.OUTPUT.flush();
			ConverterConfig.OUTPUT.close();
		}
	}

	/**
	 * Checks and configures verbosity and force
	 * @param cmd The CommandLine object that's been parsed already
	 */
	static void configureSpecial(CommandLine cmd) {
		if (cmd.hasOption('v')) {
			ConverterConfig.DEBUG = System.err;
			Printer.log("OK, going to be very verbose...");
		}

		if (cmd.hasOption('f')) {
			ConverterConfig.FORCE = true;
			Printer.log("OK, forcing conversion...");
		}
	}

	/**
	 * Checks and configures input
	 * @param cmd The CommandLine object that's been parsed already
	 */
	static void configureInput(CommandLine cmd) {
		String inputFileName = cmd.getOptionValue('i');


		String inputExt = FilenameUtils.getExtension(inputFileName);
		ConverterConfig.INPUT_FORMAT = extToFormat(inputExt);
		ConverterConfig.INPUT_PATH = inputFileName;
		Printer.log("Input format detected as: " + ConverterConfig.INPUT_FORMAT.toString());

		if (ConverterConfig.INPUT_FORMAT == Format.GALAXY) {
			if (!cmd.hasOption("galaxy-app-dir")) {
				throw new InvalidInputException("Input format Galaxy requires option --galaxy-app-dir");
			} else {
				ConverterConfig.GALAXY_INPUT_DIR = cmd.getOptionValue("galaxy-app-dir");
			}
		}

		File inputFile = new File(inputFileName);

		if (!inputFile.exists()) {
			throw new InvalidInputException("No such file: " + ConverterConfig.INPUT_PATH);
		}

		if (inputFile.isDirectory()) {
			throw new InvalidInputException("Don't specify directory, specify a file");
		}
	}

	/**
	 * Checks and configures output
	 * @param cmd The CommandLine object that's been parsed already
	 * @throws IOException
	 */
	static void configureOutput(CommandLine cmd) {
		String outputFileName = null;

		if (cmd.hasOption('c') && cmd.hasOption('o')) {
			throw new InvalidInputException("Can't use mutually exclusive options -c and -o");
		}

		if (cmd.hasOption('o')) {
			outputFileName = cmd.getOptionValue('o');
			ConverterConfig.OUTPUT_FORMAT = extToFormat(FilenameUtils.getExtension(outputFileName));
			ConverterConfig.OUTPUT_PATH = outputFileName;
		} else if (cmd.hasOption("output-format")) {
			String outputExt = cmd.getOptionValue("output-format");
			ConverterConfig.OUTPUT_FORMAT = extToFormat(outputExt);
			String fileNameWithoutExt = FilenameUtils.removeExtension(cmd.getOptionValue('i'));
			outputFileName = fileNameWithoutExt + "." + outputExt;
			if (cmd.hasOption('c')) {
				ConverterConfig.OUTPUT = System.out;
			} else {
				ConverterConfig.OUTPUT_PATH = outputFileName;
			}
		}

		if (cmd.hasOption('o') && cmd.hasOption("output-format") && !FilenameUtils.getExtension(cmd.getOptionValue('o')).equals(cmd.getOptionValue("output-format"))) {
			throw new InvalidInputException("Selected output format doesn't match output file name");
		}

		Printer.log("Output format detected as: " + ConverterConfig.OUTPUT_FORMAT);

		if (ConverterConfig.OUTPUT_FORMAT == Format.GALAXY) {
			if (!cmd.hasOption("galaxy-output-app-dir")) {
				throw new InvalidInputException("Output format Galaxy requires option --galaxy-output-app-dir");
			} else {
				ConverterConfig.GALAXY_OUTPUT_DIR = cmd.getOptionValue("galaxy-output-app-dir");
			}
		}

		if ((ConverterConfig.OUTPUT == null && ConverterConfig.OUTPUT_PATH == null) || ConverterConfig.OUTPUT_FORMAT == null) {
			throw new InvalidInputException("You didn't specify an output path and/or format");
		}

		if (ConverterConfig.INPUT_PATH.equals(ConverterConfig.OUTPUT_PATH) || (ConverterConfig.INPUT_FORMAT == Format.GALAXY && ConverterConfig.OUTPUT_FORMAT == Format.GALAXY && ConverterConfig.GALAXY_INPUT_DIR.equals(ConverterConfig.GALAXY_OUTPUT_DIR))) {
			throw new InvalidInputException("I won't let you overwrite your input file(s)");
		}

		if (ConverterConfig.INPUT_FORMAT == ConverterConfig.OUTPUT_FORMAT) {
			String sameFormatErrorString = "Input and output formats are the same";
			if (ConverterConfig.FORCE) {
				Printer.log(sameFormatErrorString);
			} else {
				throw new InvalidInputException(sameFormatErrorString);
			}
		}

		if (ConverterConfig.OUTPUT_PATH != null && (new File(ConverterConfig.OUTPUT_PATH)).exists()) {
			String outputExistsErrorString = "Output file already exists";
			if (ConverterConfig.FORCE) {
				Printer.log(outputExistsErrorString);
			} else {
				throw new InvalidInputException(outputExistsErrorString); /* also detects directories by the same name, which is ok in Windows but not in Unix */
			}
		}

	}

	/**
	 * Converts an extension (without the period) to a Format
	 *
	 * @param inputExt Extension (ga, t2flow, pipe)
	 * @return Format enum
	 */
	static Format extToFormat(String inputExt) {
		Format inputForm = null;
		for (int i = 0; i < Format.values().length; i++) {
			if (inputExt.equals(Format.values()[i].getExtension())) {
				inputForm = Format.values()[i];
				break;
			}
		}
		if (inputForm == null) {
			throw new InvalidInputException("Invalid file extension: " + inputExt);
		}

		return inputForm;
	}

	/**
	 * Set up the options for this program.
	 *
	 * @return Options object with valid command-line arguments.
	 */
	static Options makeOptions() {
		Options options = new Options();

		Option toStdout = new Option("c", false, "print output to stdout instead of to file (requires --output-format)");

		Option force = new Option("f", "force", false, "force (attempt to ignore errors)");

		Option input = new Option("i", "input", true, "input file");
		input.setArgs(1);
		input.setRequired(true);

		Option output = new Option("o", "output", true, "output file (if -c and --output-format not specified)");
		output.setArgs(1);

		Option outputFormat = new Option("p", "output-format", false, "output file format (if --output not specified or -c specified)");
		outputFormat.setArgs(1);

		Option galaxyDir = new Option("g", "galaxy-app-dir", true, "input directory for Galaxy .xml files");
		galaxyDir.setArgs(1);

		Option galaxyOutputDir = new Option("j", "galaxy-output-app-dir", true, "output directory for Galaxy .xml files");
		galaxyOutputDir.setArgs(1);

		Option verbose = new Option("v", "verbose", false, "be verbose (print debug messages to stderr)");

		/* help option is actually ignored, because other options are required--missing a required option results in printing help */
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
