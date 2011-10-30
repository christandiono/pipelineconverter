package Taverna.Tree;

import java.util.List;
import java.util.ArrayList;

public class GranularDepthPorts extends TavernaNode {
	public GranularDepthPorts(){
		ports = new ArrayList<GranularDepthPort>();
	}
	
	public void addPort(GranularDepthPort p){
		ports.add(p);
	}
	
	List<GranularDepthPort> ports;
}
