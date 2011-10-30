package LONI.tree;

public class Annotations extends LoniNode {

	public boolean isVisible() {
		return visible;
	}

	private final boolean visible;

	public Annotations(boolean visible) {
		super();
		this.visible = visible;
	}
}
