package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Workflow extends TavernaNode {
	private final Dataflow dataflow;
	private final String producedBy;
	
	public Workflow(Dataflow dataflow, String producedBy){
		this.dataflow = dataflow; 
		this.producedBy = producedBy;
	}

	public Dataflow getDataflow() {
		return dataflow;
	}

	public String getProducedBy() {
		return producedBy;
	}
}
