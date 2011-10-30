package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class DataLink extends TavernaNode {
	private final Link sink;
	private final Link source;
	
	public DataLink(Link sink, Link source){
		this.sink = sink;
		this.source = source;
	}

	public Link getSink() {
		return sink;
	}

	public Link getSource() {
		return source;
	}
}