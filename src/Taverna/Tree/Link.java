package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class Link extends TavernaNode {
	private final LinkType linkType;
	private final ProcessorName processor;
	private final PortName port;
	
	public Link(LinkType linkType, ProcessorName processor, PortName port){
		this.linkType = linkType;
		this.processor = processor;
		this.port = port;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public ProcessorName getProcessor() {
		return processor;
	}

	public PortName getPort() {
		return port;
	}
}