package Galaxy.Tree.Workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Galaxy.Tree.GalaxyNode;

public class Step extends GalaxyNode{
	private final int id;
	private final String name;
	private final String annotation;
	private final String toolId;
	private final String toolVersion;
	private final String toolState;
	private final String toolType;
	private final Position stepPosition;
	private final Map<String, InputConnection> connections;
	private final List<ExternalOutput> externalOutputs;
	private final List<ExternalInput> externalInputs;
	
	public Step(int id, String name, String annotation, 
			String toolId,  String toolVersion, 
			String toolState, String toolType, 
			Position stepPosition){
		this.id =id;
		this.name = name;
		this.annotation = annotation;
		this.toolId = toolId;
		this.toolVersion = toolVersion;
		this.toolState = toolState;
		this.toolType = toolType;
		this.stepPosition = stepPosition;
		externalOutputs = new ArrayList<ExternalOutput>();
		externalInputs = new ArrayList<ExternalInput>();
		connections = new TreeMap<String, InputConnection>();
	}
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
