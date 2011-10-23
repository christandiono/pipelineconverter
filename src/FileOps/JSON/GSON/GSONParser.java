package FileOps.JSON.GSON;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Core.Node;
import FileOps.JSON.JSONHandler;
import FileOps.JSON.JSONParser;

public class GSONParser<T> implements JSONParser<T> {
	GsonBuilder builder;
	GSONFieldNamingStrategy fieldNamingStrategy;
	
	public GSONParser(){
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
	public T parse(String json){
		T obj = null;
		Gson parser = builder.create();
		//T obj = (T) parser.fromJson(json.getPath(), ref.getClass());
		return obj;
	}

}
