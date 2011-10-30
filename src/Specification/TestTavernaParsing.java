package Specification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import CLInterface.ConverterConfig;
import Taverna.Tree.*;

public class TestTavernaParsing {
	public static void main(String[] args){
		TestSpecifications.testTavernaXML("data/Taverna/input/tav1.t2flow", "data/Taverna/output/tav2.t2flow");
	}
}
