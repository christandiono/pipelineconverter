package Parser.JSON;


import java.lang.reflect.Type;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public abstract class CaseHandler<T> implements JsonSerializer<T>, JsonDeserializer<T> {
	Type caseType;
	
	public CaseHandler(Type t){
		this.caseType = t;
	}
	public Type getType(){
		return caseType;
	}
}
