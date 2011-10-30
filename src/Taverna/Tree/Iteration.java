package Taverna.Tree;

public class Iteration extends TavernaNode {
	public Iteration(){}
	
	public Iteration(IterationNode in){
		iterationNode = in;
	}
	
	private IterationNode iterationNode;

	public IterationNode getIterationNode() {
		return iterationNode;
	}

	public void setIterationNode(IterationNode iterationNode) {
		this.iterationNode = iterationNode;
	}
}
