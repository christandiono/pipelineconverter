package Specification;

import FileOps.Generator;
import FileOps.Parser;
import FileOps.XStream.XStreamWrapper;
import LONI.tree.Pipeline;
import Taverna.Tree.*;

public class TavernaSpecification {
	private static XStreamWrapper<Workflow> xstream = new XStreamWrapper<Workflow>();
	private static boolean initialized = false;
	
	private static void init(){
		initXML();
		initialized = true;
	}
	
	public static void initXML(){
		xstream.bindElementToClass(Workflow.class, "workflow");
		// First comes from class field name, second is from .xsd file
		// Workflow bindings
		xstream.bindAttributeToClassField(Workflow.class, "dataflow", "dataflow");
		xstream.bindAttributeToClassField(Workflow.class, "producedBy", "producedBy");
		xstream.bindAttributeToClassField(Workflow.class, "version", "version");
		xstream.bindAttributeToClassField(Workflow.class, "xmlns", "xmlns");
		
		// dataflow bindings
		xstream.bindElementToClass(Dataflow.class, "dataflow");
		xstream.bindElementToClassField(Dataflow.class, "name", "name");
		xstream.bindElementToClassField(Dataflow.class, "inputPorts", "inputPorts");
		xstream.bindElementToClassField(Dataflow.class, "outputPorts", "outputPorts");
		xstream.bindElementToClassField(Dataflow.class, "processors", "processors");
		xstream.bindElementToClassField(Dataflow.class, "conditions", "conditions");
		xstream.bindElementToClassField(Dataflow.class, "datalinks", "datalinks");
		//xstream.bindElementToClassField(Workflow.class, "annotations", "annotations");
		xstream.bindAttributeToClassField(Dataflow.class, "id", "id");
		xstream.bindAttributeToClassField(Dataflow.class, "role", "role");
		
		// UUID bindings
		xstream.bindElementToClass(UUID.class, "uuid");
		xstream.bindAttributeToClassField(UUID.class, "role", "role");
		
		// annotations bindings
		
	}
	
	public static Parser<Workflow> getXMLParser(){
		if(!initialized)
			init();
		return xstream;
	}
	
	public static Generator<Workflow> getXMLGenerator(){
		if(!initialized)
			init();
		return xstream;
	}
}
