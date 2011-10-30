package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Condition extends TavernaNode {
	private final ProcessorName control;
	private final ProcessorName target;
	
	public Condition(ProcessorName control, ProcessorName target){
		this.control = control;
		this.target = target;
	}

	public ProcessorName getControl() {
		return control;
	}

	public ProcessorName getTarget() {
		return target;
	}
}