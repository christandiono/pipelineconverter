package Taverna.Tree.Layers;
import Taverna.Tree.TavernaNode;

public class ParallelizeConfig extends TavernaNode {
	private final int maxJobs;
	
	public ParallelizeConfig(int maxjobs) {
		this.maxJobs = maxjobs;
	}

	public int getMaxJobs() {
		return maxJobs;
	}
}