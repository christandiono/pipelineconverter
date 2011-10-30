package LONI.tree;

public class MetadataName extends LoniNode {


	public MetadataName(String nameOption, String nameValue) {
		super();
		this.nameOption = nameOption;
		this.nameValue = nameValue;
	}
	public String getNameOption() {
		return nameOption;
	}
	public String getNameValue() {
		return nameValue;
	}
	private final String nameOption;
	private final String nameValue;
}
