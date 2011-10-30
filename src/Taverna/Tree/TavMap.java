package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class TavMap extends TavernaNode {
	private List<Mapping> mappings;
	
	public TavMap(){
		this.mappings = new ArrayList<Mapping>();
	}

	public List<Mapping> getMappings() {
		return mappings;
	}
	
	public void addMapping(Mapping mapping) {
		mappings.add(mapping);
	}
	
}