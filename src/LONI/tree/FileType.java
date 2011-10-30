package LONI.tree;

public class FileType extends LoniNode {


	public FileType(String name, String extension, String description) {
		super();
		this.name = name;
		this.extension = extension;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public String getExtension() {
		return extension;
	}
	public String getDescription() {
		return description;
	}
	private final String name;
	private final String extension;
	private final String description;
}
