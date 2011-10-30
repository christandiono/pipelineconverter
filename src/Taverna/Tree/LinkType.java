package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class LinkType extends TavernaNode {
	private final String linkType;
	
	public LinkType(String linkType){
		this.linkType = linkType;
	}

	public String getLinkType() {
		return linkType;
	}
}