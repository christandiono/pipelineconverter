package LONI.tree;

public class Compiler extends LoniNode {


	public String getName() {
		return name;
	}
	public String getVersion() {
		return version;
	}
	public String getFlags() {
		return flags;
	}
	public String getUpdates() {
		return updates;
	}
	public Compiler(String name, String version, String flags, String updates) {
		super();
		this.name = name;
		this.version = version;
		this.flags = flags;
		this.updates = updates;
	}
	private final String name;
	private final String version;
	private final String flags;
	private final String updates;
}
