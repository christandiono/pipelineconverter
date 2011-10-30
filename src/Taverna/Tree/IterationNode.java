package Taverna.Tree;

public class IterationNode extends TavernaNode {
	public IterationNode(){}
	
	public IterationNode(PortProduct pp){
		port = pp;
	}
	
	// IterationNode in .xsd file contains two IterationNodes itself, not sure what to do here!
	
	PortProduct port;
}
