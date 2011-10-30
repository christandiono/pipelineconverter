package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class Map extends TavernaNode {
	private List<Mapping> mappings;
	
	public Map(){
		this.mappings = new ArrayList<Mapping>();
	}

	public List<Mapping> getMappings() {
		return mappings;
	}
	
	public void addMapping(Mapping mapping) {
		mappings.add(mapping)
	}
	
}