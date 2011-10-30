package Taverna.Tree;

public class DepthPort extends Port {
	public DepthPort(){}
	
	public DepthPort(int d){
		depth = d;
	}
	
	private int depth;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
