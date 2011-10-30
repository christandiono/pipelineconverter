package Taverna.Tree;

public class GranularDepthPort extends DepthPort {
	public GranularDepthPort(){}
	
	public GranularDepthPort(int gd){
		granularDepth = gd;
	}
	
	int granularDepth;
}
