package LONI.tree;

public class MetadataElement extends LoniNode {


	public MetadataElement(String location, String prefix,
			boolean spaceAfterPrefix) {
		super();
		this.location = location;
		this.prefix = prefix;
		this.spaceAfterPrefix = spaceAfterPrefix;
	}
	public String getLocation() {
		return location;
	}
	public String getPrefix() {
		return prefix;
	}
	public boolean isSpaceAfterPrefix() {
		return spaceAfterPrefix;
	}
	private final String location;
	private final String prefix;
	private final boolean spaceAfterPrefix;
}
