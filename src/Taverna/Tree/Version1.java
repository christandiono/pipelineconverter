package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Version1 extends TavernaNode {
	private final String version;
	
	public Version1(String version){
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

}