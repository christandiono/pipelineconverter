package FileOps.XML;

import java.io.File;

public interface XMLGenerator<T> {
	
	public void generate(T object, String destination);
}
