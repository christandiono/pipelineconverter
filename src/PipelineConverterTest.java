import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Test cases for PipelineConverter
 * 
 * @author Chris Tandiono
 */
public class PipelineConverterTest {

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

}