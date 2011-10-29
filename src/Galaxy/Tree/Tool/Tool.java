package Galaxy.Tree.Tool;

import Galaxy.Tree.GalaxyNode;

public class Tool extends GalaxyNode{
	String Description;
	String ID;
	String FullName;
	String Version;
	Inputs ToolInputs;
	Command ToolCommand;
	String Help;
	
	public String getID(){
		return ID;
	}

}
