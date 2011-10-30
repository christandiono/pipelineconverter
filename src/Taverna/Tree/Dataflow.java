package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Dataflow extends TavernaNode {
	private final String name;
	private final AnnotatedGranularDepthPorts inputPorts;
	private final AnnotatedPorts outputPorts;
	private final Processors processors;
	private final Conditions conditions;
	private final Datalinks datalinks;
	private final Annotations annotations;
	private final UUID id;
	private final Role role;
	
	Dataflow(String name, AnnotatedGranularDepthPorts inputPorts, AnnotatedPorts outputPorts, Processors processors, Conditions conditions, Datalinks datalinks, Annotations annotations, UUID id, Role role){
		this.name = name;
		this.inputPorts = inputPorts;
		this.outputPorts = outputPorts;
		this.processors = processors;
		this.conditions = conditions;
		this.datalinks = datalinks;
		this.annotations = annotations;
		this.id = id;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public AnnotatedGranularDepthPorts getInputPorts() {
		return inputPorts;
	}

	public AnnotatedPorts getOutputPorts() {
		return outputPorts;
	}

	public Processors getProcessors() {
		return processors;
	}

	public Conditions getConditions() {
		return conditions;
	}

	public Datalinks getDatalinks() {
		return datalinks;
	}

	public Annotations getAnnotations() {
		return annotations;
	}

	public UUID getId() {
		return id;
	}

	public Role getRole() {
		return role;
	}
		
}
