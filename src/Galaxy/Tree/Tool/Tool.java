package Galaxy.Tree.Tool;

import Galaxy.Tree.GalaxyNode;

public class Tool extends GalaxyNode{
	String description;
	String id;
	String fullName;
	String version;
	Inputs toolInputs;
	Command toolCommand;
	String help;
	
	public String getID(){
		return id;
	}

}
