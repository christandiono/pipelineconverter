package Galaxy.Tree.Workflow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Tool.Tool;

public class Workflow extends GalaxyNode {
	private final String name;
	private final String annotation;
	private final String formatVersion;
	private final boolean isGalaxyWorkflow;
	private final Map<Integer,Step> steps;
	
	public Workflow(String name, String annotation, String formatVersion,
			boolean isGalaxyWorkflow){
		this.steps = new TreeMap<Integer, Step>();
		this.isGalaxyWorkflow = isGalaxyWorkflow;
		this.formatVersion =  formatVersion;
		this.name = name;
		this.annotation = annotation;
	}
	
	public String getName(){
		return name;
	}
	public String getAnnotation(){
		return annotation;
	}
	public String getFormatVersion(){
		return formatVersion;
	}
	public boolean isGalaxyWorkflow(){
		return isGalaxyWorkflow;
		
	}
	public Step getStep(int i){
		if(steps.containsKey(i))
			return steps.get(i);
		return null;
	}
	public Collection<Step> getSteps(){
		return steps.values();
	}
	
	public void addStep(int key, Step value) {
		steps.put(key, value);
	}
}
