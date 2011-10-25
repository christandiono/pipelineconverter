package Galaxy.Tree.Workflow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Galaxy.Tree.GalaxyNode;

public class Workflow extends GalaxyNode {
	private String Name;
	private String Annotation;
	private Float FormatVersion;
	private Boolean isGalaxyWorkflow;
	private Map<Integer,Step> Steps;
	
	public String getName(){
		return Name;
	}
	public String getAnnotation(){
		return Annotation;
	}
	public float getFormatVersion(){
		return FormatVersion;
	}
	public boolean isGalaxyWorkflow(){
		return isGalaxyWorkflow;
		
	}
	public Step getStep(int i){
		if(Steps.containsKey(i))
			return Steps.get(i);
		return null;
	}
	public Collection<Step> getSteps(){
		return Steps.values();
	}
	
	
}
