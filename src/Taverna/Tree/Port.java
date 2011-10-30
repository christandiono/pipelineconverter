package Taverna.Tree;

import Taverna.Tree.TavernaNode;

public class Port extends TavernaNode {
	public Port()
	{
		
	}
	
	public Port(PortName pn)
	{
		portName = pn;
	}
	
	public void setPortName(PortName pn)
	{
		portName = pn;
	}
	
	public PortName getPortName()
	{
		return portName;
	}
	
	private PortName portName;
}
