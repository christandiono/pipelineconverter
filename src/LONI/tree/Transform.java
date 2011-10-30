package LONI.tree;

public class Transform extends LoniNode {


	private final int order;
	private final String operation;
	
	public Transform(int order, String operation) {
		super();
		this.order = order;
		this.operation = operation;
	}
	public int getOrder() {
		return order;
	}
	public String getOperation() {
		return operation;
	}
	
	
}
