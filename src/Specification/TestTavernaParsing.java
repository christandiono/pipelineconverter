package Specification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import CLInterface.ConverterConfig;
import Galaxy.Tree.Tool.Tool;
import Taverna.Tree.*;

public class TestTavernaParsing {
	
	public static void testTavernaXML(String path, String output){
		System.out.println("==="+path+"===");
		Workflow G;
		try {
			G = TavernaSpecification.getXMLParser().parse(new File(path));
			try {
				TavernaSpecification.getXMLGenerator().generate(G, output);
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
		testTavernaXML("data/Taverna/input/tav1.t2flow", "data/Taverna/output/tav2.t2flow");
	}
}
