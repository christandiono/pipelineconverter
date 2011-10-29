package Specification;


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
	private static XStreamWrapper<Tool> xstream = new XStreamWrapper<Tool>();
	private static GalaxyToolDatabase tooldb;
	
	private static boolean initialized = false;
	
	private static void init(){
		initJSON();
		initXML();
		initialized = true;
		
	}

	private static void initXML(){
		xstream.bindElementToClass(Tool.class, "tool");
		xstream.bindElementToClassField(Tool.class, "Description", "description");
		xstream.bindAttributeToClassField(Tool.class, "ID", "id");
		xstream.bindAttributeToClassField(Tool.class, "FullName", "name");
		xstream.bindAttributeToClassField(Tool.class, "Version", "version");
		xstream.bindElementToClass(Command.class, "command");
		xstream.bindElementToClass(Inputs.class, "inputs");
		xstream.bindGroupToArray(Inputs.class, "InputList");
		xstream.bindElementToClass(Parameter.class, "param");
		
	}
	
	private static void initJSON(){
		gson.bindTag(Workflow.class, "Name", "name");
		gson.bindTag(Workflow.class, "FormatVersion", "format-version");
		gson.bindTag(Workflow.class, "Annotation", "annotation");
		gson.bindTag(Workflow.class, "isGalaxyWorkflow", "a_galaxy_workflow");
		gson.bindTag(Workflow.class, "Steps", "steps");
		
		gson.bindTag(Step.class, "Name", "name");
		gson.bindTag(Step.class, "Annotation", "annotation");
		gson.bindTag(Step.class, "Id", "id");
		gson.bindTag(Step.class, "ToolId", "tool_id");
		gson.bindTag(Step.class, "Connections", "input_connections");
		gson.bindTag(Step.class, "ExternalInputs", "inputs");
		gson.bindTag(Step.class, "ExternalOutputs", "outputs");
		gson.bindTag(Step.class, "StepPosition", "position");
		gson.bindTag(Step.class, "ToolVersion", "tool_version");
		gson.bindTag(Step.class, "ToolState", "tool_state");
		gson.bindTag(Step.class, "ToolType", "type");
		
		gson.bindTag(Position.class, "UnitsFromLeftMargin", "left");
		gson.bindTag(Position.class, "UnitsFromTopMargin", "top");
		gson.bindTag(ExternalOutput.class, "Name", "name");
		gson.bindTag(ExternalOutput.class, "Type", "type");
		gson.bindTag(InputConnection.class, "SourceId", "id");
		gson.bindTag(InputConnection.class, "OutputName", "output_name");
		
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
