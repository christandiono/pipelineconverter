package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class ProcessorName extends TavernaNode {
	private final String processorName;
	
	public ProcessorName(String processorName){
		this.processorName = processorName;
	}

	public String getProcessorName() {
		return processorName;
	}
	
}