package CLInterface;
/**
 * A file for the Format enum.
 */

/**
 * The Format enum contains all allowed formats.
 * 
 * @author Chris Tandiono
 */
public enum Format {
	LONI("pipe"), GALAXY("ga"), TAVERNA("t2flow");
	
	private final String extension;
	
	/**
	 * Constructor that sets the extension of this item.
	 * @param extension File extension (no included period)
	 */
	private Format(String extension) {
		this.extension = extension;
	}
	
	/**
	 * Gets the file extension of this item, without the period.
	 * @return File extension (no included period)
	 */
	public String getExtension() {
		return this.extension;
	}
}