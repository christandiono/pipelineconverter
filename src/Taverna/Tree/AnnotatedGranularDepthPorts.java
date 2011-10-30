package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class AnnotatedGranularDepthPorts extends TavernaNode {
	public List<AnnotatedGranularDepthPort> ports;
	
	AnnotatedGranularDepthPorts() {
		ports = new ArrayList<AnnotatedGranularDepthPort>();
	}
	
	public List<AnnotatedGranularDepthPort> getPorts() {
		return ports;
	}
	
	public void addPorts(AnnotatedGranularDepthPort port) {
		ports.add(port);
	}
}