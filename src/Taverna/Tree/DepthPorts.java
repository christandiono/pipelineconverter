package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class DepthPorts extends TavernaNode {
	private List<DepthPort> depthPorts;
	
	public DepthPorts(){
		this.depthPorts = new ArrayList<DepthPort>();
	}

	public List<DepthPort> getDepthPorts() {
		return depthPorts;
	}

	public void addDepthPort(DepthPort port) {
		depthPorts.add(port);
	}	
}