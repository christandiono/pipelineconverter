package LONI.tree;

public class Metadata extends LoniNode {

	private final Data data;

	public Data getData() {
		return data;
	}

	public Metadata(Data data) {
		super();
		this.data = data;
	}
}
