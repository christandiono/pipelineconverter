package FileOps.JSON.GSON;


import java.lang.reflect.Type;


import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public abstract interface GSONHandler<T> extends JsonSerializer<T>, JsonDeserializer<T> {
	
}
