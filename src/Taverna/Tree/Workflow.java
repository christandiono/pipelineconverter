package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Workflow extends TavernaNode {
	private final Dataflow dataflow;
	private final String producedBy;
	private final String version;
	private final String xmlns;
	
	public Workflow(Dataflow dataflow, String producedBy, String version, String xmlns){
		this.dataflow = dataflow; 
		this.producedBy = producedBy;
		this.version = version;
		this.xmlns = xmlns;
	}

	public Dataflow getDataflow() {
		return dataflow;
	}

	public String getProducedBy() {
		return producedBy;
	}
	
	public String getVersion(){
		return version;
	}
}
