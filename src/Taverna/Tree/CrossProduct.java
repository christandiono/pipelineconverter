package Taverna.Tree;
import Taverna.Tree.TavernaNode;
import java.util.List;
import java.util.ArrayList;

public class CrossProduct extends TavernaNode {
	private List<Products> crosses;
	
	public CrossProduct(){
		this.crosses = new ArrayList<Products>();
	}

	public List<Products> getCrosses() {
		return crosses;
	}

	public void addPort(Products products) {
		crosses.add(products);
	}	
}