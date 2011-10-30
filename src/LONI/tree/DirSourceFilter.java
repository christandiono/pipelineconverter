package LONI.tree;

public class DirSourceFilter extends LoniNode {


	public String getCondition() {
		return condition;
	}

	public DirSourceFilter(String condition) {
		super();
		this.condition = condition;
	}

	private final String condition;
}
