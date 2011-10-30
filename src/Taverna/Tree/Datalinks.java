package Taverna.Tree;

import java.util.ArrayList;
import java.util.List;

public class Datalinks extends TavernaNode {
	public Datalinks(){
		datalinks = new ArrayList<DataLink>();
	}
	
	public void addDataLink(DataLink d){
		datalinks.add(d);
	}
	
	public List<DataLink> getDataLinks(){
		return datalinks;
	}
	
	private List<DataLink> datalinks;
}
