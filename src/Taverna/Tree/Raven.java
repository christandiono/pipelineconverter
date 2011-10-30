package Taverna.Tree;

public class Raven extends TavernaNode {
	public Raven(String g, String a, String v){
		group = g;
		artifact = a;
		version = v;
	}
	
	private String group;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getArtifact() {
		return artifact;
	}
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	private String version;
	private String artifact;
}
