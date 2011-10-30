package LONI.tree;

public class Connection extends LoniNode {


	public String getSource() {
		return source;
	}
	public String getSink() {
		return sink;
	}
	public Connection(String source, String sink) {
		super();
		this.source = source;
		this.sink = sink;
	}
	private final String source;
	private final String sink;
}
