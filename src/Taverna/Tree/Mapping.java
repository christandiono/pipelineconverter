package Taverna.Tree;

public class Mapping extends TavernaNode {
	public Mapping(){
		
	}
	
	public Mapping(PortName f, PortName t){
		from = f;
		to = t;
	}
	
	private PortName from;
	public PortName getFrom() {
		return from;
	}
	public void setFrom(PortName from) {
		this.from = from;
	}
	public PortName getTo() {
		return to;
	}
	public void setTo(PortName to) {
		this.to = to;
	}

	private PortName to;
}
