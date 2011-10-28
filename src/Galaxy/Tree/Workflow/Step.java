package Galaxy.Tree.Workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

import Galaxy.Tree.GalaxyNode;

public class Step extends GalaxyNode{
	int Id;
	String Name;
	String Annotation;
	String ToolId;
	String ToolVersion;
	String ToolState;
	String ToolType;
	Position StepPosition;
	Map<String, InputConnection> Connections;
	List<ExternalOutput> ExternalOutputs;
	List<ExternalInput> ExternalInputs;
	
	public int getId(){
		return Id;
	}
	public String getName(){
		return Name;
	}
	public String getAnnotation(){
		return Annotation;
	}
	public String getToolId(){
		return ToolId;
	}
	public String getToolVersion(){
		return ToolVersion;
	}
	public Position getPosition(){
		return StepPosition;
	}
	public Set<String> getConnectionSinks(){
		return Connections.keySet();
	}
	public InputConnection getConnectionSource(String Sink){
		return Connections.get(Sink);
	}

}
