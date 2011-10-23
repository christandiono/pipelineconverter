package CLInterface;
import static org.junit.Assert.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.junit.Before;
import org.junit.Test;


/**
 * Test cases for PipelineConverter
 * 
 * @author Chris Tandiono
 */
public class PipelineConverterTest {

	Options options;
	CommandLineParser parser;
	
	/**
	 * @throws Exception if setUp was unsuccessful
	 */
	@Before
	public void setUp() throws Exception {
		options = PipelineConverter.makeOptions();
		parser = new PosixParser();
	}
	
	/**
	 * Tests conversion of file extension to Format enum
	 */
	@Test
	public final void testExtToFormat() {
		assertTrue(PipelineConverter.extToFormat("ga") == Format.GALAXY);
		assertTrue(PipelineConverter.extToFormat("pipe") == Format.LONI);
		assertTrue(PipelineConverter.extToFormat("t2flow") == Format.TAVERNA);
		try {
			PipelineConverter.extToFormat(".ga");
			fail("Failed to avoid invalid input");
		} catch (InvalidInputException e) { }
		try {
			PipelineConverter.extToFormat("a");
			fail("Failed to avoid invalid input");
		} catch (InvalidInputException e) { }
		try {
			PipelineConverter.extToFormat("ga ");
			fail("Failed to avoid invalid input");
		} catch (InvalidInputException e) { }
	}

	/**
	 * Tests extraction of proper extension from filename
	 */
	@Test
	public final void testExtractExt() {
		assertTrue(PipelineConverter.extractExt("asdf.ga").equals("ga"));
		assertTrue(PipelineConverter.extractExt("asdf.t2flow").equals("t2flow"));
		assertTrue(PipelineConverter.extractExt("asdf.pipe").equals("pipe"));
		
		/* formats we shouldn't be encountering */
		assertTrue(PipelineConverter.extractExt("asdf.tar.gz").equals("gz"));
		assertTrue(PipelineConverter.extractExt(".ga").equals("ga"));
		try {
			PipelineConverter.extractExt("asdfasdf");
			fail("Failed to avoid invalid input");
		} catch (InvalidInputException e) { }
	}
	
	/**
	 * Simple test with simple arguments
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputSimple() throws ParseException {
		String[] args = {"-i", "foo.pipe", "-o", "bar.t2flow", "-v"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.LONI);
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.pipe"));
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("bar.t2flow"));
		assertTrue(ConverterConfig.DEBUG != null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT == null);
		assertTrue(ConverterConfig.VERBOSE);
	
	}
	
	/**
	 * Tests -c option
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputStdout() throws ParseException {
		String[] args = {"-i", "foo.pipe", "--output-format", "t2flow", "-c"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.LONI);
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.pipe"));
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.DEBUG == null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT != null);
		assertTrue(!ConverterConfig.VERBOSE);
	}
	
	/**
	 * Tests Galaxy input (valid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyIn() throws ParseException {
		String[] args = {"-i", "foo.ga", "--galaxy-app-dir", ".", "--output-format", "t2flow"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.ga"));
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.DEBUG == null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR.equals("."));
		assertTrue(ConverterConfig.OUTPUT == null);
		assertTrue(!ConverterConfig.VERBOSE);
	}
	
	/**
	 * Tests Galaxy input (invalid command line). No Galaxy app dir has been configured, so an error should result.
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyIn() throws ParseException {
		String[] args = {"-i", "foo.ga", "--output-format", "t2flow"};
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			PipelineConverter.configureOutput(cmd);
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) {
			/* do nothing: this is the expected result */
		}
	}
	
	/**
	 * Tests Galaxy output (valid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyOut() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "--output-format", "ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("foo.ga"));
		assertTrue(ConverterConfig.DEBUG == null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR.equals("."));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT == null);
		assertTrue(!ConverterConfig.VERBOSE);
	}
	
	/**
	 * Tests Galaxy output (valid command line) again
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyOut2() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "-o", "asdf.ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("asdf.ga"));
		assertTrue(ConverterConfig.DEBUG == null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR.equals("."));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT == null);
		assertTrue(!ConverterConfig.VERBOSE);
	}
	
	/**
	 * Tests Galaxy output (invalid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyOut() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--output-format", "ga"};
		try {
			CommandLine cmd = parser.parse(options, args);
			PipelineConverter.configureOutput(cmd);
		} catch (InvalidInputException e) {
			/* do nothing */
		}
	}
	
	/**
	 * Tests Galaxy output (invalid command line) again
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyOut2() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "-o", "asdf.ga"};
		try {
			CommandLine cmd = parser.parse(options, args);
			PipelineConverter.configureOutput(cmd);
		} catch (InvalidInputException e) {
			/* do nothing */
		}
	}
	
}