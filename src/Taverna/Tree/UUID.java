package Taverna.Tree;

import Taverna.Tree.TavernaNode;

public class UUID extends TavernaNode {
	public UUID(String newUUID)
	{
		uuid = newUUID;
	}
	
	public String getUUID()
	{
		return uuid;
	}
	
	public void setUUID(String newUUID)
	{
		uuid = newUUID;
	}
	
	private String uuid;
}
