package Galaxy.Tree.Tool;

import Galaxy.Tree.GalaxyNode;
import Galaxy.Visitor.DFSVisitor;

public class Parameter extends GalaxyNode{
	
	String name;
	String type;
	String label;
	String help;
	
	public Parameter(String name, String type, String label, String help) {
		super();
		this.name = name;
		this.type = type;
		this.label = label;
		this.help = help;
	}
	
	
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	public String getLabel(){
		return label;
	}
	public String getHelp(){
		return help;
	}
}
