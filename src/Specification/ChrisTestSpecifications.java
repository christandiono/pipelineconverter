package Specification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import CLInterface.ConverterConfig;
import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Tool.Tool;
import Galaxy.Tree.Workflow.Workflow;
import Galaxy.Toolbox.GalaxyToolDatabase;
import Galaxy.Visitor.GalaxyToLoniConverter;
import LONI.tree.Pipeline;
import LONI.visitor.LoniToGalaxyConverter;

public class ChrisTestSpecifications {
	public static void main(String[] args){
		//testJSON("data/test2.ga");
		ConverterConfig.GALAXY_INPUT_DIR = "/home/chris/galaxy-dist/";
		ConverterConfig.GALAXY_OUTPUT_DIR = "/home/chris/foo/";
		
		testPipelineConverter("data/Loni/input/loni_input_output.pipe", "data/Loni/input/gal1.ga");
		
		
	
	}
	private static void testPipelineConverter(String path, String output) {
		// TODO Auto-generated method stub
		System.out.println("==="+path+"===");
		Pipeline p;
		try {
			p = LoniSpecification.getXMLParser().parse(new File(path));
			LoniToGalaxyConverter lgc = new LoniToGalaxyConverter();
			Workflow workflow = (Workflow) lgc.visit(p);
			
			try {
				GalaxySpecification.getJSONGenerator().generate(workflow, output);
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
