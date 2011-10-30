package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class PortName extends TavernaNode {
	private final String portName;
	
	public PortName(String portName){
		this.portName = portName;
	}

	public String getPortName() {
		return portName;
	}
	
}