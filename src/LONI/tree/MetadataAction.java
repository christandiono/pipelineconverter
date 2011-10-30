package LONI.tree;

public class MetadataAction extends LoniNode {


	public MetadataAction(String location, String action) {
		super();
		this.location = location;
		this.action = action;
	}
	public String getLocation() {
		return location;
	}
	public String getAction() {
		return action;
	}
	private final String location;
	private final String action;
}
