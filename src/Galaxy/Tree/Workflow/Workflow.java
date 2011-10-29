package Galaxy.Tree.Workflow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Tool.Tool;

public class Workflow extends GalaxyNode {
	private String name;
	private String annotation;
	private Float formatVersion;
	private Boolean isGalaxyWorkflow;
	private Map<Integer,Step> steps;
	
	public Workflow(){
		steps = new TreeMap<Integer, Step>();
	}
	public String getName(){
		return name;
	}
	public String getAnnotation(){
		return annotation;
	}
	public float getFormatVersion(){
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
	
	
}
