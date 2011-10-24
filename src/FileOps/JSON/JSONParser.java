package FileOps.JSON;

import java.io.File;
import java.io.FileNotFoundException;



public interface JSONParser<T> {
	public void bindHandler(JSONHandler handler);
	public void bindTag(Class parent, String field, String tag);
	public T parse(String json);
	public T parse(File json) throws FileNotFoundException;
}
