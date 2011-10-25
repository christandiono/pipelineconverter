package Specification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Workflow.Workflow;

public class TestGalaxySpecification {

	public static void main(String[] args){
		String path = "data/test2.ga";
		Workflow G;
		try {
			G = GalaxySpecification.getJSONParser().parse(new File(path));

			try {
				GalaxySpecification.getJSONGenerator().generate(G, "data/output.ga");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
