package FileOps.XStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import javax.xml.stream.XMLStreamException;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.UnknownFieldException;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.StaxWriter;

import FileOps.Generator;
import FileOps.Parser;

public class XStreamWrapper<T> implements Parser<T>, Generator<T>{
	XStream xstream;
	
	public XStreamWrapper(){
		xstream =new XStream(new DomDriver()); 
	}
	/**
	 * Bind an element in the XML file to a class.
	 * For example:
	 * XML Snippet:
	 * 		<tool id ...></tool>
	 * Class Snippet:
	 * 		class Tool{ }
	 * bindElementToClass(Tool.class, "tool")
	 * 
	 * @param classToBind class to bind the element tag to.
	 * @param alias name of the tag to bind to.
	 */
	public void bindElementToClass(Class classToBind, String alias){
		xstream.alias(alias, classToBind);
	}
	/**
	 * Bind an element in the xml file to the field of a class.
	 * For example:
	 * XML Snippet:
	 * 		<tool><description>hello</description></tool>
	 * Class Snippet:
	 * 		class Tool{
	 * 			String desc;
	 * 		}
	 * bindElementToClassField(Tool.class, "desc", "description");
	 * @param classToBind Class the field to bind belongs to.
	 * @param field Field in class to bind.
	 * @param alias Element tag to bind field in class to.
	 */
	public void bindElementToClassField(Class classToBind, String field, String alias){
		xstream.aliasField(alias,  classToBind, field);
	}
	/***
	 * Bind an attribute of an element to a class.
	 * XML Example:
	 * 		<tool id="hello"></tool>
	 * Class Example:
	 * 		class Tool{
	 * 			String id;
	 *		} 	
	 *
	 *bindAttributeToClassField(Tool.class, "id", "id");
	 * @param classToBind Class field belongs to.
	 * @param attributeName name of field to bind.
	 * @param alias attribute tag belonging to some element.
	 */
	public void bindAttributeToClassField(Class classToBind, String attributeName, String alias){
		xstream.aliasAttribute(classToBind, attributeName, alias);
		
	}
	
	/**
	 * Mark a field in a Class as a List of elements.
	 * Example:
	 * 	XML Snippet:
	 * 		<modulegroup>
	 * 			<module></module>
	 * 			<module></module>
	 * 		</modulegroup>
	 * 	Class Snippet:
	 * 		class Module{}
	 * 		class ModuleGroup{
	 * 			List<Module> modules;
	 * 		}
	 * bindElementToClass("module", Module.class);
	 * bindElementToClass("modulegroup", Module.class);
	 * bindGroupToList<ModuleGroup.class, "modules");
	 * @param classWithArray Class the list of objects belongs to.
	 * @param arrayFieldName Name of field that holds a listof objects.
	 */
	public void bindGroupToList(Class classWithArray, String arrayFieldName){
		xstream.addImplicitArray(classWithArray, arrayFieldName);
	}
	
	@Override
	public T parse(String xml) {
		// TODO Auto-generated method stub
		T parsedObject=(T) xstream.fromXML(xml);
		return parsedObject;
	}
	

	@Override
	public T parse(File xml) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Reader reader = new BufferedReader( new FileReader(xml.getPath()));
		try{
			T parsedObject=(T) xstream.fromXML(reader);
			return parsedObject;
		}
		catch(UnknownFieldException e){
			System.err.println("XML PARSE ERROR: " + e.getShortMessage());
		}
		return null;
		
	}

	@Override
	public void generate(T object, String path) throws IOException {
		// TODO Auto-generated method stub
		Writer writer = new BufferedWriter( new FileWriter(path));
		writer.write("<?xml version=\"1.0\"?>\n");
		xstream.toXML(object, writer);
		writer.close();
		
	}

	@Override
	public String generate(T object) {
		// TODO Auto-generated method stub
		String xml = "<?xml version=\"1.0\"?>\n";
		xml = xstream.toXML(object);
		return xml;
	}

}
