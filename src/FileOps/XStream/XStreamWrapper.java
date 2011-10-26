package FileOps.XStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.UnknownFieldException;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import FileOps.Generator;
import FileOps.Parser;

public class XStreamWrapper<T> implements Parser<T>, Generator<T>{
	XStream xstream;
	
	public XStreamWrapper(){
		xstream = new XStream(new StaxDriver());
	}
	//Bind the class name to some piece of text in the xml file.
	public void bindElementToClass(Class classToBind, String alias){
		xstream.alias(alias, classToBind);
	}
	public void bindElementToClassField(Class classToBind, String field, String alias){
		xstream.aliasField(alias,  classToBind, field);
	}
	public void bindAttributeToClassField(Class classToBind, String attributeName, String alias){
		xstream.aliasAttribute(classToBind, attributeName, alias);
	}
	public void bindAttributeToUniversalField(String attributeName, String alias){
		xstream.aliasAttribute(alias, attributeName);
	}
	
	public void bindGroupToArray(Class classWithArray, String arrayFieldName){
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
		writer.write(xstream.toXML(object));
		writer.close();
		
	}

	@Override
	public String generate(T object) {
		// TODO Auto-generated method stub
		String xml = xstream.toXML(object);
		return xml;
	}

}
