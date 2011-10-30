package Specification;

import FileOps.Generator;
import FileOps.Parser;
import FileOps.XStream.XStreamHandler;
import FileOps.XStream.XStreamWrapper;
import Galaxy.Tree.Tool.Tool;
import LONI.tree.Connection;
import LONI.tree.Connections;
import LONI.tree.Parameter;
import LONI.tree.Pipeline;
import LONI.tree.GraphObject.Module;
import LONI.tree.GraphObject.ModuleGroup;

public class LoniSpecification {
	private static XStreamWrapper<Pipeline> xstream = new XStreamWrapper<Pipeline>();
	private static boolean initialized = false;
	
	private static void init(){
		initXML();
		initialized = true;
		
	}
	
	private static void initXML(){
		
		xstream.bindElementToClass(Pipeline.class, "pipeline");
		xstream.bindAttributeToClassField(Pipeline.class, "version", "version");
		xstream.bindAttributeToClassField(Pipeline.class, "pipelineModuleGroup", "moduleGroup");
		xstream.bindElementToClass(ModuleGroup.class, "moduleGroup");
		xstream.bindAttributeToClassField(ModuleGroup.class, "id", "id");
		xstream.bindAttributeToClassField(ModuleGroup.class, "name", "name");
		xstream.bindAttributeToClassField(ModuleGroup.class, "myPackage", "package");
		xstream.bindAttributeToClassField(ModuleGroup.class, "version", "version");
		xstream.bindAttributeToClassField(ModuleGroup.class, "description", "description");
		xstream.bindAttributeToClassField(ModuleGroup.class, "posX", "posX");
		xstream.bindAttributeToClassField(ModuleGroup.class, "posY", "posY");
		
		xstream.bindAttributeToClassField(Pipeline.class, "connections", "connections");
		xstream.bindElementToClass(Connections.class, "connections");
		/* Connections instance variables go here */

		xstream.bindGroupToList(Connections.class, "connections");
		
		xstream.bindElementToClass(Connection.class, "connection");
		//xstream.bindElementToClassField(ModuleGroup.class, "connections", "connections");
	
		
		xstream.bindGroupToList(ModuleGroup.class, "modules");
		xstream.bindElementToClass(Module.class, "module");
		xstream.bindAttributeToClassField(Module.class, "myPackage", "package");
		xstream.bindAttributeToClassField(Module.class, "id", "id");
		xstream.bindAttributeToClassField(Module.class, "location", "location");
		xstream.bindAttributeToClassField(Module.class, "description", "description");
		xstream.bindAttributeToClassField(Module.class, "rotation", "rotation");
		xstream.bindAttributeToClassField(Module.class, "version", "version");
		xstream.bindAttributeToClassField(Module.class, "name", "name");
		xstream.bindAttributeToClassField(Module.class, "executableVersion", "executableVersion");
		xstream.bindAttributeToClassField(Module.class, "name", "name");
		xstream.bindAttributeToClassField(Module.class, "posX", "posX");
		xstream.bindAttributeToClassField(Module.class, "posY", "posY");
		xstream.bindGroupToList(Module.class , "inputs");
		xstream.bindGroupToList(Module.class , "outputs");
		
		xstream.bindElementToClass(Parameter.class, "input");
		xstream.bindAttributeToClassField(Parameter.class, "name", "name");
		xstream.bindAttributeToClassField(Parameter.class, "required", "required");
		xstream.bindAttributeToClassField(Parameter.class, "enabled", "enabled");
		xstream.bindAttributeToClassField(Parameter.class, "order", "order");
		xstream.bindAttributeToClassField(Parameter.class, "id", "id");
		xstream.bindAttributeToClassField(Parameter.class, "predefined", "predefined");
		xstream.bindAttributeToClassField(Parameter.class, "isMetadata", "isMetadata");
		xstream.bindAttributeToClassField(Parameter.class, "isListFile", "isListFile");
		xstream.bindAttributeToClassField(Parameter.class, "isHideData", "isHideData");
		xstream.bindAttributeToClassField(Parameter.class, "includeTransformedParameter", "includeTransformedParameter");
		xstream.bindAttributeToClassField(Parameter.class, "prefix", "prefix");
		xstream.bindAttributeToClassField(Parameter.class, "description", "description");
		
	}

	public static Parser<Pipeline> getXMLParser(){
		if(!initialized)
			init();
		return xstream;
	}
	public static Generator<Pipeline> getXMLGenerator(){
		if(!initialized)
			init();
		return xstream;
	}

}
