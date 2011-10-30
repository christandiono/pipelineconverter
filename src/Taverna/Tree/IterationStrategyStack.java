package Taverna.Tree;

public class IterationStrategyStack extends TavernaNode {
	public IterationStrategyStack(){}
	
	public IterationStrategyStack(Iteration i){
		iteration = i;
	}
	
	private Iteration iteration;

	public Iteration getIteration() {
		return iteration;
	}

	public void setIteration(Iteration iteration) {
		this.iteration = iteration;
	}
}
