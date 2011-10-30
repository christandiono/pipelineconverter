package Galaxy.Tree.Tool;

import Galaxy.Tree.GalaxyNode;

public class Tool extends GalaxyNode{
	String description;
	String id;
	String fullName;
	String version;
	Inputs toolInputs;
	Outputs toolOutputs;
	Command toolCommand;
	String help;
	
	public Tool(String id, String fullName, String description,
			String version, Inputs toolInputs, Command toolCommand,
			String help){
		this.id = id;
		this.fullName = fullName;
		this.description = description;
		this.version = version;
		this.toolInputs = toolInputs;
		this.toolCommand = toolCommand;
		this.help = help;
		
	}
	public String getID(){
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getVersion() {
		return version;
	}
	public Inputs getToolInputs() {
		return toolInputs;
	}
	public Command getToolCommand() {
		return toolCommand;
	}
	public String getHelp() {
		return help;
	}

}
