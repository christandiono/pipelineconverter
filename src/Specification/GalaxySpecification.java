package Specification;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import FileOps.Generator;
import FileOps.Parser;
import FileOps.GSON.GSONWrapper;
import FileOps.XStream.XStreamWrapper;
import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Tool.Command;
import Galaxy.Tree.Tool.Inputs;
import Galaxy.Tree.Tool.Parameter;
import Galaxy.Tree.Tool.Tool;
import Galaxy.Tree.Workflow.*;
import Galaxy.Toolbox.GalaxyToolDatabase;

public class GalaxySpecification {
	private static GSONWrapper<Workflow> gson = new GSONWrapper<Workflow>(Workflow.class);
	private static XStreamWrapper<Tool> xstream = new XStreamWrapper<Tool>(){
		final GalaxyToolDatabase database= new GalaxyToolDatabase();
		
		public void generate(Tool tool, String path) throws IOException{
			super.generate(tool, path);
			database.dumpDatabase();
			
		}
		public String generate(Tool tool){
			String s = super.generate(tool);
			database.dumpDatabase();
			return s;
		}
	};
	
	private static boolean initialized = false;
	
	private static void init(){
		initJSON();
		initXML();
		initialized = true;
		
	}

	private static void initXML(){
		xstream.bindElementToClass(Tool.class, "tool");
		xstream.bindElementToClassField(Tool.class, "description", "description");
		xstream.bindAttributeToClassField(Tool.class, "id", "id");
		xstream.bindAttributeToClassField(Tool.class, "fullName", "name");
		xstream.bindAttributeToClassField(Tool.class, "version", "version");
		xstream.bindElementToClass(Command.class, "command");
		xstream.bindElementToClass(Inputs.class, "inputs");
		xstream.bindGroupToList(Inputs.class, "inputList");
		xstream.bindElementToClass(Parameter.class, "param");
		
	}
	
	private static void initJSON(){
		gson.bindTag(Workflow.class, "name", "name");
		gson.bindTag(Workflow.class, "formatVersion", "format-version");
		gson.bindTag(Workflow.class, "annotation", "annotation");
		gson.bindTag(Workflow.class, "isGalaxyWorkflow", "a_galaxy_workflow");
		gson.bindTag(Workflow.class, "steps", "steps");
		
		gson.bindTag(Step.class, "name", "name");
		gson.bindTag(Step.class, "annotation", "annotation");
		gson.bindTag(Step.class, "id", "id");
		gson.bindTag(Step.class, "toolId", "tool_id");
		gson.bindTag(Step.class, "connections", "input_connections");
		gson.bindTag(Step.class, "externalInputs", "inputs");
		gson.bindTag(Step.class, "externalOutputs", "outputs");
		gson.bindTag(Step.class, "stepPosition", "position");
		gson.bindTag(Step.class, "toolVersion", "tool_version");
		gson.bindTag(Step.class, "toolState", "tool_state");
		gson.bindTag(Step.class, "toolType", "type");
		
		gson.bindTag(Position.class, "unitsFromLeftMargin", "left");
		gson.bindTag(Position.class, "unitsFromTopMargin", "top");
		gson.bindTag(ExternalOutput.class, "name", "name");
		gson.bindTag(ExternalOutput.class, "type", "type");
		gson.bindTag(InputConnection.class, "sourceId", "id");
		gson.bindTag(InputConnection.class, "outputName", "output_name");
		
	}
	
	
	public static Parser<Workflow> getJSONParser(){
		if(!initialized)
			init();
		return gson;
	}
	public static Generator<Workflow> getJSONGenerator(){
		if(!initialized)
			init();
		return gson;
	}
	
	public static Parser<Tool> getXMLParser(){
		if(!initialized)
			init();
		return xstream;
	}
	public static Generator<Tool> getXMLGenerator(){
		if(!initialized)
			init();
		return xstream;
	}
	
	

}
