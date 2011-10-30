package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class Products extends TavernaNode {
	private List<PortProduct> ports;
	
	public Products(){
		this.ports = new ArrayList<PortProduct>();
	}

	public List<PortProduct> getProducts() {
		return ports;
	}

	public void addPort(PortProduct port) {
		ports.add(port);
	}	
}