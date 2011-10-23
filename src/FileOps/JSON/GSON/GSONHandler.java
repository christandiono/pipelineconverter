package FileOps.JSON.GSON;


import java.lang.reflect.Type;

import Parser.JSON.JSONHandler;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface GSONHandler<T> extends JsonSerializer<T>, JsonDeserializer<T>, JSONHandler {
	
}
