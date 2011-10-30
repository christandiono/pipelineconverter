package Taverna.Tree;

import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class Ports extends TavernaNode {
	public Ports()
	{
		portList = new ArrayList<Port>();
	}
	
	public void addPort(Port p)
	{
		portList.add(p);
	}
	
	public List<Port> getPorts()
	{
		return portList;
	}
	
	public int getNumPorts()
	{
		return portList.size();
	}
	
	private List<Port> portList;
}
