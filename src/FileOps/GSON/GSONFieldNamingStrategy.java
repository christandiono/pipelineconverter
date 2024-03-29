package FileOps.GSON;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.FieldNamingStrategy;

public class GSONFieldNamingStrategy implements FieldNamingStrategy{
	private Map<Class,Map<String, String>> tagmap;
	
	public GSONFieldNamingStrategy(){
		tagmap = new HashMap<Class, Map<String,String>>();
	}
	public void addTag(Class parent, String field, String tag){
		if(!tagmap.containsKey(parent)){
			tagmap.put(parent, new TreeMap<String, String>());
		}
		tagmap.get(parent).put(field, tag);
	}
	private String getTag(Class parent, String field){
		if(tagmap.containsKey(parent))
			return tagmap.get(parent).get(field);
		return null;
	}
	@Override
	public String translateName(Field arg0) {
		// TODO Auto-generated method stub
		Class fieldClass = arg0.getDeclaringClass();
		String fieldName=  arg0.getName();
		String tag = getTag(fieldClass, fieldName);
		if(tag == null){
			System.err.println("PARSE ERROR: Could not find mapping from "+fieldClass.toString() +":" + fieldName+" to Tag");
			
		}
		return tag;
	}
	
}
