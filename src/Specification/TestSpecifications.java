package Specification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Tool.Tool;
import Galaxy.Tree.Workflow.Workflow;
import LONI.tree.Pipeline;

public class TestSpecifications {

	public static void testGalaxyJSON(String path, String output){
		System.out.println("==="+path+"===");
		Workflow G;
		try {
			G = GalaxySpecification.getJSONParser().parse(new File(path));
			try {
				GalaxySpecification.getJSONGenerator().generate(G, output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void testGalaxyXML(String path, String output){
		System.out.println("==="+path+"===");
		Tool G;
		try {
			G = GalaxySpecification.getXMLParser().parse(new File(path));
			try {
				GalaxySpecification.getXMLGenerator().generate(G, output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void testLoniXML(String path, String output){
		System.out.println("==="+path+"===");
		Pipeline G;
		try {
			G = LoniSpecification.getXMLParser().parse(new File(path));
			try {
				LoniSpecification.getXMLGenerator().generate(G, output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		//testJSON("data/test2.ga");
		testGalaxyJSON("data/Galaxy/input/gal1.ga", "data/Galaxy/output/gal1.ga");
		testGalaxyJSON("data/Galaxy/input/gal2.ga", "data/Galaxy/output/gal2.ga");
		
		testGalaxyXML("data/Galaxy/input/tool1.xml", "data/Galaxy/output/tool1.xml");
		
		testLoniXML("data/Loni/input/loni1.pipe", "data/Loni/output/loni1.pipe");
		testLoniXML("data/Loni/input/loni2.pipe", "data/Loni/output/loni2.pipe");
		
		
	
	}
}