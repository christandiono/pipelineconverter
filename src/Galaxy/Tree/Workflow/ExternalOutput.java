package Galaxy.Tree.Workflow;

import Galaxy.Tree.GalaxyNode;

public class ExternalOutput extends GalaxyNode {
	final String name;
	final String type;
	
	public ExternalOutput(String name, String type){
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
}
