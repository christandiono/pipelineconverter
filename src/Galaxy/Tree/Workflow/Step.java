package Galaxy.Tree.Workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

import Galaxy.Tree.GalaxyNode;

public class Step extends GalaxyNode{
	int id;
	String name;
	String annotation;
	String toolId;
	String toolVersion;
	String toolState;
	String toolType;
	Position stepPosition;
	Map<String, InputConnection> connections;
	List<ExternalOutput> externalOutputs;
	List<ExternalInput> externalInputs;
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getAnnotation(){
		return annotation;
	}
	public String getToolId(){
		return toolId;
	}
	public String getToolVersion(){
		return toolVersion;
	}
	public Position getPosition(){
		return stepPosition;
	}
	public Set<String> getConnectionSinks(){
		return connections.keySet();
	}
	public InputConnection getConnectionSource(String Sink){
		return connections.get(Sink);
	}

}
