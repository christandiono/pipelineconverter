package Taverna.Tree;

import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class Processor extends TavernaNode {
	public Processor()
	{
		inputPorts = new ArrayList<DepthPorts>();
		outputPorts = new ArrayList<GranularDepthPorts>();
	}
	
	public Processor(Activities act, DispatchStack dis, IterationStrategyStack it, ProcessorName pn,
			Annotations an)
	{
		activities = act;
		dispatchStack = dis;
		iterationStrategyStack = it;
		processorName  = pn;
		inputPorts = new ArrayList<DepthPorts>();
		outputPorts = new ArrayList<GranularDepthPorts>();
		annotations = an;
	}
	
	public Activities getActivities() {
		return activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	public DispatchStack getDispatchStack() {
		return dispatchStack;
	}

	public void setDispatchStack(DispatchStack dispatchStack) {
		this.dispatchStack = dispatchStack;
	}

	public IterationStrategyStack getIterationStrategyStack() {
		return iterationStrategyStack;
	}

	public void setIterationStrategyStack(
			IterationStrategyStack iterationStrategyStack) {
		this.iterationStrategyStack = iterationStrategyStack;
	}

	public ProcessorName getProcessorName() {
		return processorName;
	}

	public void setProcessorName(ProcessorName processorName) {
		this.processorName = processorName;
	}

	public List<DepthPorts> getInputPorts() {
		return inputPorts;
	}

	public void setInputPorts(List<DepthPorts> inputPorts) {
		this.inputPorts = inputPorts;
	}

	public List<GranularDepthPorts> getOutputPorts() {
		return outputPorts;
	}

	public void setOutputPorts(List<GranularDepthPorts> outputPorts) {
		this.outputPorts = outputPorts;
	}

	public Annotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Annotations annotations) {
		this.annotations = annotations;
	}

	private Activities activities; 
	private DispatchStack dispatchStack;
	private IterationStrategyStack iterationStrategyStack;
	private ProcessorName processorName;
	private List<DepthPorts> inputPorts;
	private List<GranularDepthPorts> outputPorts;
	private Annotations annotations;
}
