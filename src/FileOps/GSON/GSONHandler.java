package FileOps.GSON;


import java.lang.reflect.Type;


import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public abstract class GSONHandler<T> implements JsonSerializer<T>, JsonDeserializer<T> {
	Type BoundType;
}
