package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class AnnotationChain extends TavernaNode {
	// don't know what any is
	// TODO: implement <any namespace="##any" processContents="lax"></any>
	private final String encoding;
	
	public AnnotationChain(String encoding){
		this.encoding = encoding;
	}

	public String getEncoding() {
		return encoding;
	}
}