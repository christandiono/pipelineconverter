package FileOps.JSON.GSON;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Parser.JSON.JSONGenerator;
import Parser.JSON.JSONHandler;

public class GSONGenerator<T> implements JSONGenerator<T>{
	GsonBuilder builder;
	GSONFieldNamingStrategy fieldNamingStrategy;
	
	public GSONGenerator(){
		builder = new GsonBuilder();
		fieldNamingStrategy = new GSONFieldNamingStrategy();
		builder.setFieldNamingStrategy(fieldNamingStrategy);
		
	}
	
	@Override
	public void bindJSONHandler(JSONHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bindTag(String tag, Class parent, String field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generate(T object, File destination) {
		Gson gson = builder.create();
		String jsonText = gson.toJson(object);
		System.out.println(jsonText);
		
	}

}
