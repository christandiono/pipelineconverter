package CLInterface;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.cli.Options;

import Parser.JSON.JSONParser;
import Parser.XML.XMLParser;

/*
 * Command Line Interface for Converter
 * should figure out the format conversions
 * Creates a new processor
 * 
 */
public class CLInterface {
	
	public static void main(String[] args) {
		//vsx.parse("src/Parser/test.xml");
		System.out.println("------XML Parsing:------");
		Object o = XMLParser.parse("src/Parser/test2.xml");
		XMLParser.generate("", o);
		System.out.println("------------------------");
		System.out.println("------JSON Parsing:------");
		Object o2 = JSONParser.parse("src/Parser/test.ga");
		JSONParser.generate("",o2);
		System.out.println("------------------------");
		
		
		
	}

}
