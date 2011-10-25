package Parser.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import CLInterface.Printer;
import Galaxy.JSON.GalaxyJSONLoader;
import Galaxy.Tree.Tool.Tool;
import Galaxy.XML.GalaxyXMLLoader;
import Parser.Parser;

/*

XStream


*/

public class XMLParser implements Parser{

	public static void generate(String destPath, Object dump) {
		// TODO Auto-generated method stub
		//Use XStream
		XStream xstream = GalaxyXMLLoader.getLoader();
		Printer.output(xstream.toXML(dump));
	}

	public static Object parse(String path) {
		FileInputStream filestream;
		XStream xstream = GalaxyXMLLoader.getLoader();
		Tool parsedTree = new Tool();
		
		try {
			filestream = new FileInputStream(path);
			xstream.fromXML(filestream, parsedTree);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return parsedTree;
		
	}

	
	
	
}
