package CLInterface;
import static org.junit.Assert.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.junit.After;
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
	 * @throws Exception if tearDown was unsuccessful
	 */
	@After
	public void tearDown() throws Exception {
		ConverterConfig.reset();
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
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) { }
		try {
			PipelineConverter.extToFormat("a");
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) { }
		try {
			PipelineConverter.extToFormat("ga ");
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) { }
	}
	
	/**
	 * Simple test with no arguments
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputNoArgs() {
		String[] args = {"-i", "foo.pipe", "-o", "bar.t2flow", "-v"};
		try {
			@SuppressWarnings("unused")
			CommandLine cmd = parser.parse(options, args);
		} catch (ParseException e) {
			/* do nothing */
		}
	}
	
	/**
	 * Simple test with simple arguments
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureInputSimple() throws ParseException {
		String[] args = {"-i", "foo.pipe", "-o", "bar.t2flow", "-v"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.LONI);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.pipe"));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
	}
	
	/**
	 * Simple test with simple arguments
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputSimple() throws ParseException {
		String[] args = {"-i", "foo.pipe", "-o", "bar.t2flow", "-v"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("bar.t2flow"));
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT == null);
	}
	
	/**
	 * Tests -c option
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureInputStdout() throws ParseException {
		String[] args = {"-i", "foo.pipe", "--output-format", "t2flow", "-c"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.LONI);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.pipe"));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
	}
	
	/**
	 * Tests -c option
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputStdout() throws ParseException {
		String[] args = {"-i", "foo.pipe", "--output-format", "t2flow", "-c"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.OUTPUT_PATH == null);
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT != null);
	}
	
	/**
	 * Tests Galaxy input (valid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureInputValidGalaxyIn() throws ParseException {
		String[] args = {"-i", "foo.ga", "--galaxy-app-dir", ".", "--output-format", "t2flow"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.ga"));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR.equals("."));
	}
	
	/**
	 * Tests Galaxy input (valid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyIn() throws ParseException {
		String[] args = {"-i", "foo.ga", "--galaxy-app-dir", ".", "--output-format", "t2flow"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR == null);
		assertTrue(ConverterConfig.OUTPUT == null);
	}
	
	/**
	 * Tests Galaxy input (invalid command line: no input app dir)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyIn() throws ParseException {
		String[] args = {"-i", "foo.ga", "--output-format", "t2flow"};
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			PipelineConverter.configureInput(cmd);
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
	public final void testConfigureInputValidGalaxyOut() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "--output-format", "ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
	}
	
	/**
	 * Tests Galaxy output (valid command line)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyOut() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "--output-format", "ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("foo.ga"));
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR.equals("."));
		assertTrue(ConverterConfig.OUTPUT == null);
	}
	
	/**
	 * Tests Galaxy output (valid command line) again
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureInputValidGalaxyOut2() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "-o", "asdf.ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		
		assertTrue(ConverterConfig.INPUT_FORMAT == Format.TAVERNA);
		assertTrue(ConverterConfig.INPUT_PATH.equals("foo.t2flow"));
		assertTrue(ConverterConfig.GALAXY_INPUT_DIR == null);
	}
	
	/**
	 * Tests Galaxy output (valid command line) again
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputValidGalaxyOut2() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--galaxy-output-app-dir", ".", "-o", "asdf.ga"};
		CommandLine cmd = parser.parse(options, args);
		PipelineConverter.configureInput(cmd);
		PipelineConverter.configureOutput(cmd);
		
		assertTrue(ConverterConfig.OUTPUT_FORMAT == Format.GALAXY);
		assertTrue(ConverterConfig.OUTPUT_PATH.equals("asdf.ga"));
		assertTrue(ConverterConfig.GALAXY_OUTPUT_DIR.equals("."));
		assertTrue(ConverterConfig.OUTPUT == null);
	}
	
	/**
	 * Tests Galaxy output (invalid command line: missing output app dir)
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyOut() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "--output-format", "ga"};
		try {
			CommandLine cmd = parser.parse(options, args);
			PipelineConverter.configureOutput(cmd);
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) {
			/* do nothing */
		}
	}
	
	/**
	 * Tests Galaxy output (invalid command line: missing output app dir) again
	 * @throws ParseException if the test has been improperly configured
	 */
	@Test
	public final void testConfigureOutputInvalidGalaxyOut2() throws ParseException {
		String[] args = {"-i", "foo.t2flow", "-o", "asdf.ga"};
		try {
			CommandLine cmd = parser.parse(options, args);
			PipelineConverter.configureOutput(cmd);
			fail("Failed to catch invalid input");
		} catch (InvalidInputException e) {
			/* do nothing */
		}
	}
	
}