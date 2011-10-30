package Taverna.Tree.Layers;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class Properties extends TavernaNode {
	private List<Property> properties;
	
	public Properties(){
		properties = new ArrayList<Property>();
	}

	public List<Property> getProperty() {
		return properties;
	}
	
	public void addProperty(Property property) {
		properties.add(property);
	}
}