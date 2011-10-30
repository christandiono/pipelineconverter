package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class PortProduct extends TavernaNode {
	private final PortName portName;
	private final int depth;
	
	public PortProduct(PortName portName, int depth){
		this.portName = portName;
		this.depth = depth;
	}

	public PortName getPortName() {
		return portName;
	}

	public int getDepth() {
		return depth;
	}
	
}