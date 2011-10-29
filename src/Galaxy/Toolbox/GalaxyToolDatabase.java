package Galaxy.Toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.UnknownFieldException;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import CLInterface.ConverterConfig;
import Core.Pair;
import FileOps.XStream.XStreamWrapper;
import Galaxy.Tree.Tool.Tool;
import Specification.GalaxySpecification;

public class GalaxyToolDatabase {
	Map<String, Pair<String, Tool>> ToolIndex;
	
	class Toolbox{
		List<Section> sections;
	}
	class Section{
		List<Entry> entries;
	}
	class Entry{}
	class ToolEntry extends Entry{
		String path;
	}
	class Label extends Entry{
		String text;
	}
	
	
	public void visit(ToolEntry toolentry){
		String toolpath;
		toolpath = (String) ConverterConfig.GALAXY_INPUT_DIR;
		toolpath += "tools/";
		toolpath += toolentry.path;
		XStream xstream;
		BufferedReader reader;
		
		xstream = new XStream(new StaxDriver());
		try {
			reader = new BufferedReader(new FileReader(toolpath));
			StaxDriver xmlParser = new StaxDriver();
			HierarchicalStreamReader xmlPeeker= xmlParser.createReader(reader);
			String tool_id= xmlPeeker.getAttribute("id");
			ToolIndex.put(tool_id, new Pair<String, Tool>(toolpath, null));
			reader.close();
		} catch(StreamException e){
			System.err.println("Error loading "+ toolentry.path);
			System.err.println(e.getCause().toString());
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error loading "+ toolentry.path);
			System.err.println(e.getCause());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error loading "+ toolentry.path);
			System.err.println(e.getCause());
		}
		
		//Tool parsedTool = GalaxySpecification.getXMLParser().parse(toolentry.path);
		
	}
	public void visit(Section section){
		for(Entry entry : section.entries){
			if(entry instanceof ToolEntry){
				ToolEntry toolentry = (ToolEntry) entry;
				visit(toolentry);
			}
		}
	}
	public void visit(Toolbox toolbox){
		for(Section section : toolbox.sections){
			visit(section);
		}
	}
	public GalaxyToolDatabase(){
		ToolIndex = new HashMap<String, Pair<String, Tool>>();
		XStreamWrapper<Toolbox> parser = new XStreamWrapper<Toolbox>();
		parser.bindElementToClass(Toolbox.class, "toolbox");
		parser.bindElementToClass(Section.class, "section");
		parser.bindElementToClass(ToolEntry.class, "tool");
		parser.bindElementToClass(Label.class,  "label");
		parser.bindGroupToArray(Toolbox.class, "sections");
		parser.bindGroupToArray(Section.class, "entries");
		parser.bindAttributeToClassField(ToolEntry.class, "path", "file");
		try {
			Toolbox mydb;
			mydb = parser.parse(new File(ConverterConfig.GALAXY_INPUT_DIR+"tool_conf.xml"));
			visit(mydb);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Galaxy Directory not found: Cannot load tools");
			
		}
	}
	
	public Tool getTool(String id){
		
			if(ToolIndex.containsKey(id)){
				Tool tool;
				Pair<String, Tool> storedTool= ToolIndex.get(id);
				if(storedTool.getElem2() == null){
					
					try {
						tool = GalaxySpecification.getXMLParser().parse(new File(storedTool.getElem1()));
						storedTool.setElem2(tool);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return storedTool.getElem2();
			}
		return null;
	}
	
}
