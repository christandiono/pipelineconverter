package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class AnnotatedPorts extends TavernaNode {
	private List<AnnotatedPort> annotatedPorts;
	
	public AnnotatedPorts(){
		this.annotatedPorts = new ArrayList<AnnotatedPort>();
	}

	public List<AnnotatedPort> getAnnotatedPorts() {
		return annotatedPorts;
	}

	public void addDepthPort(AnnotatedPort port) {
		annotatedPorts.add(port);
	}	
}