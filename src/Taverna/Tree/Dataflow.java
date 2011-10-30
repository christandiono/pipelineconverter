package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Dataflow extends TavernaNode {
	private final String name;
	private final AnnotatedGranularDepthPorts inputPorts;
	private final AnnotatedPorts outputPorts;
	private final Processors processors;
	private final Conditions conditions;
	
}
