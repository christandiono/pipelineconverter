package Taverna.Tree;

import java.util.List;
import java.util.ArrayList;

public class Processors extends TavernaNode {
	public Processors(){
		processors = new ArrayList<Processor>();
	}
	
	public void addProcessor(Processor p){
		processors.add(p);
	}
	
	public List<Processor> getProcessors(){
		return processors;
	}
	
	private List<Processor> processors;
}
