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
import java.util.Set;
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
	final String INDEX_NAME = "tool_conf.xml";
	final String TOOL_DIRECTORY = "tools";
	Map<String, Pair<String, Tool>> toolDB;
	XStreamWrapper<Toolbox> toolIndexParser;
	Toolbox toolIndex;
	
	
	class Toolbox{
		List<Section> sections;
		
	}
	class Section{
		List<Entry> entries;
		String name;
		String id;
	}
	class Entry{}
	class ToolEntry extends Entry{
		String path;
	}
	class LabelEntry extends Entry{
		String label;
	}
	/**
	 * Convert a relative tool path to an absolute tool path that points
	 * to where the source files for the tool are.
	 * @param relativePath the path of the tool relative to the tool directory.
	 * @return the absolute path of the specified input file for the tool.
	 */
	private String relativePathToInputToolPath(String relativePath){
		String toolPath;
		toolPath = (String) ConverterConfig.GALAXY_INPUT_DIR;
		toolPath += TOOL_DIRECTORY + "/";
		toolPath += relativePath;
		return toolPath;
	}
	/**
	 * Convert a relative tool path to an absolute tool path that points to
	 * where the tool file should be written.
	 * @param relativePath the path of the tool relative to the tool directory.
	 * @return the absolute path of the specified output file for the tool.
	 */
	private String relativePathToOutputToolPath(String relativePath){
		String toolPath;
		toolPath = (String) ConverterConfig.GALAXY_OUTPUT_DIR;
		toolPath += TOOL_DIRECTORY + "/";
		toolPath += relativePath;
		return toolPath;
	}
	/**
	 * Visits all the objects in the parsed tool index tree and populates the database
	 * object entries in the database.
	 * @author viper
	 *
	 */
	class ToolIndexVisitor{
		/**
		 * Scrapes the tool's XML file to find the id of the tool. The XML file is not
		 * fully parsed in this operation.
		 * @param relative path of the tool from the root of the tool directory.
		 * @return the id of the tool that was scraped from the file.
		 */
		private String getToolIdFromToolXML(String relativePath){
			String toolPath;
			XStream xstream;
			BufferedReader reader;
			toolPath = relativePathToInputToolPath(relativePath);
			System.out.println(toolPath);
			xstream = new XStream(new StaxDriver());
			try {
				reader = new BufferedReader(new FileReader(toolPath));
				StaxDriver xmlParser = new StaxDriver();
				HierarchicalStreamReader xmlPeeker= xmlParser.createReader(reader);
				String tool_id= xmlPeeker.getAttribute("id");
				reader.close();
				return tool_id;
			} catch(StreamException e){
				System.err.println("Error loading "+ relativePath);
				System.err.println(e.getCause().toString());
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Error loading "+ relativePath);
				System.err.println(e.getCause());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error loading "+ relativePath);
				System.err.println(e.getCause());
			}
			return "";
		}
		
		
		public void visit(ToolEntry toolentry){
			
			String tool_id = getToolIdFromToolXML(toolentry.path);
			if(tool_id.equals("") == false)
				toolDB.put(tool_id, new Pair<String, Tool>(
					    toolentry.path, 
						null
						));
			
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
	}
	/**
	 * Setup the tool index parser and initialize the tool database.
	 */
	public GalaxyToolDatabase(){
		toolDB = new HashMap<String, Pair<String, Tool>>();
		toolIndexParser = new XStreamWrapper<Toolbox>();
		
		toolIndexParser.bindElementToClass(Toolbox.class, "toolbox");
		toolIndexParser.bindElementToClass(Section.class, "section");
		toolIndexParser.bindAttributeToClassField(Section.class, "name", "name");
		toolIndexParser.bindAttributeToClassField(Section.class, "id", "id");
		toolIndexParser.bindElementToClass(ToolEntry.class, "tool");
		toolIndexParser.bindAttributeToClassField(ToolEntry.class, "path", "file");
		toolIndexParser.bindElementToClass(LabelEntry.class,  "label");
		toolIndexParser.bindAttributeToClassField(LabelEntry.class, "label", "text");
		toolIndexParser.bindAttributeToClassField(LabelEntry.class, "label", "text");
		toolIndexParser.bindGroupToList(Toolbox.class, "sections");
		toolIndexParser.bindGroupToList(Section.class, "entries");
		
	}
	/**
	 * Load the database index file and the file path - id mappings.
	 */
	public void loadDatabase(){
		try {
			ToolIndexVisitor indexVisitor = new ToolIndexVisitor();
			toolIndex = toolIndexParser.parse(new File(ConverterConfig.GALAXY_INPUT_DIR + INDEX_NAME));
			indexVisitor.visit(toolIndex);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Galaxy Directory not found: Cannot load tools");
			
		}
	}
	/**
	 * Dump the tool database to the Galaxy output directory. Dumps the updated index file
	 * and all the tools in their appropriate directories. Tools that cannot be dumped are skipped.
	 */
	public void dumpDatabase(){
		try {
			toolIndexParser.generate(toolIndex, ConverterConfig.GALAXY_OUTPUT_DIR + INDEX_NAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String id : toolDB.keySet()){
			Pair<String, Tool> currentTool = toolDB.get(id);
			String relativePath = currentTool.getElem1();
			Tool toolToDump = currentTool.getElem2();
			if(toolToDump != null){
				try {
					GalaxySpecification.getXMLGenerator().generate(toolToDump, 
							relativePathToOutputToolPath(relativePath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
	/**
	 * Get a section of the tool index file by name.
	 * @param sectionName name of section to get.
	 * @return section with specified name.
	 */
	private Section getSection(String sectionName){
		for(Section section : toolIndex.sections){
			if(section.id.equals(sectionName))
				return section;
		}
		return null;
	}
	/**
	 * The addTool method in the ToolDatabase class allows the user to add a
	 * tool to the database.
	 * @param packageName The name of the package the tool belongs to.
	 * @param tool The tool object to add to the tool database.
	 */
	public void addTool(String packageName,Tool tool){
		String id = tool.getID();
		String relPath = packageName + "/"+id+".xml";
		toolDB.put(id, new Pair(relPath, tool));
		/*
		 * Add to index tree.
		 */
		ToolEntry toolEntry = new ToolEntry();
		toolEntry.path = relPath;
		Section idxSection = getSection(packageName);
		idxSection.entries.add(toolEntry);
		
		
	}
	/**
	 * Retrieves a tool object from the database using the provided tool id. If
	 * the tool object is not loaded into the database, its .xml specification file is
	 * parsed and the tool is loaded. If the key is not found, then null is returned.
	 * @param toolId the id name of the tool to retrieve.
	 * @return the tool object in the database.
	 */
	public Tool getTool(String toolId){
		
			if(toolDB.containsKey(toolId)){
				Tool tool;
				Pair<String, Tool> databaseTool= toolDB.get(toolId);
				/*
				If the tool has never been parsed. Parse it and store it.
				*/
				if(databaseTool.getElem2() == null){
					
					try {
						tool = GalaxySpecification.getXMLParser().parse(
								new File(relativePathToInputToolPath(databaseTool.getElem1()))
								);
						databaseTool.setElem2(tool);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return databaseTool.getElem2();
			}
		return null;
	}
	
}
