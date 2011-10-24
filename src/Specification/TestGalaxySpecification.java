package Specification;

import java.io.File;
import java.io.FileNotFoundException;

import Galaxy.Tree.GalaxyNode;

public class TestGalaxySpecification {

	public static void main(String[] args){
		String path = "data/test.ga";
		GalaxyNode G;
		try {
			G = GalaxySpecification.getJSONParser().parse(new File(path));
			GalaxySpecification.getJSONGenerator().generate(G, "");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
