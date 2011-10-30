package Taverna.Tree.Layers;
import Taverna.Tree.TavernaNode;

public class Properties extends TavernaNode {
	private final Property property;
	
	public Properties(Property property){
		this.property = property;
	}

	public Property getProperty() {
		return property;
	}
}