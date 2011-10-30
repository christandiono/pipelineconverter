package Taverna.Tree.Layers;
import Taverna.Tree.TavernaNode;

public class RetryConfig extends TavernaNode {
	private final double backoffFactor;
	private final long initialDelay;
	private final long maxDelay;
	private final int maxRetries;
	
	public RetryConfig(double backoffFactor, long initialDelay, long maxDelay, int maxRetries){
		this.backoffFactor = backoffFactor;
		this.initialDelay = initialDelay;
		this.maxDelay = maxDelay;
		this.maxRetries = maxRetries;
	}

	public double getBackoffFactor() {
		return backoffFactor;
	}

	public long getInitialDelay() {
		return initialDelay;
	}

	public long getMaxDelay() {
		return maxDelay;
	}

	public int getMaxRetries() {
		return maxRetries;
	}
}