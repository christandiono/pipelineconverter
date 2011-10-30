package Specification;

import FileOps.Generator;
import FileOps.Parser;
import FileOps.XStream.XStreamWrapper;
import Galaxy.Tree.Tool.Tool;
import LONI.tree.ModuleGroup;
import LONI.tree.Pipeline;
import LONI.tree.GraphObject.Module;

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
		xstream.bindAttributeToClassField(Pipeline.class, "workflow", "moduleGroup");
		xstream.bindElementToClass(ModuleGroup.class, "moduleGroup");
		xstream.bindAttributeToClassField(ModuleGroup.class, "ID", "id");
		xstream.bindAttributeToClassField(ModuleGroup.class, "Name", "name");
		xstream.bindAttributeToClassField(ModuleGroup.class, "Package", "package");
		xstream.bindAttributeToClassField(ModuleGroup.class, "Version", "version");
		xstream.bindAttributeToClassField(ModuleGroup.class, "Description", "description");
		xstream.bindAttributeToClassField(ModuleGroup.class, "PositionX", "posX");
		xstream.bindAttributeToClassField(ModuleGroup.class, "PositionY", "posY");
		xstream.bindGroupToList(ModuleGroup.class, "Modules");
		xstream.bindElementToClass(Module.class, "module");
		xstream.bindAttributeToClassField(Module.class, "PositionY", "posY");
		xstream.bindAttributeToClassField(Module.class, "PositionX", "posX");
		xstream.bindAttributeToClassField(Module.class, "ID", "id");
		xstream.bindAttributeToClassField(Module.class, "Location", "location");
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
