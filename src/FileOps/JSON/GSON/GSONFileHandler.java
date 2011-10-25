package FileOps.JSON.GSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import CLInterface.Printer;
import Core.Node;
import FileOps.JSON.JSONGenerator;
import FileOps.JSON.JSONHandler;
import FileOps.JSON.JSONParser;
import Galaxy.Tree.Workflow.Workflow;

public class GSONFileHandler<T extends Object> implements JSONParser<T>, JSONGenerator<T>  {
	GsonBuilder builder;
	GSONFieldNamingStrategy strategy;
	
	public GSONFileHandler(){
		builder = new GsonBuilder();
		strategy = new GSONFieldNamingStrategy();
		builder.setFieldNamingStrategy(strategy);
		
	}
	
	public void bindTag(Class parent, String field, String tag) {
		// TODO Auto-generated method stub
		strategy.addTag(parent, field, tag);
		
	}
	public T parse(String json){
		T obj = null;
		Gson parser = builder.create();
		obj = (T) parser.fromJson(json, Workflow.class );
		return obj;
	}

	public void bindHandler(Type boundType, GSONHandler handler) {
		// TODO Auto-generated method stub
		builder.registerTypeAdapter(boundType, handler);
		
	}

	@Override
	public void bindHandler(JSONHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generate(T object) {
		// TODO Auto-generated method stub
		String jsonString = builder.create().toJson(object);
		Printer.output(jsonString);
	}
	
	@Override
	public void generate(T object, String path) {
		// TODO Auto-generated method stub
		String jsonString = builder.create().toJson(object);
		try {
			File output = new File(path);
			boolean created = output.createNewFile();
			// FIXME what to do with created variable?
			if (!created) {
				throw new IOException("File exists");
			}
			Printer.output(new FileOutputStream(new File(path)), jsonString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T parse(File json) throws FileNotFoundException {
		Class<T> clazz = null;
		// TODO Auto-generated method stub
		Reader reader = new BufferedReader( new FileReader(json.getPath()));
		T object= (T) builder.create().fromJson(reader, Workflow.class);
		
		return object;
	}



	

}
