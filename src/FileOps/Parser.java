package FileOps;

import java.io.File;
import java.io.FileNotFoundException;


public interface Parser<T> {
	public T parse(String json);
	public T parse(File json) throws FileNotFoundException;
}
