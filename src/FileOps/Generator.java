package FileOps;

import java.io.IOException;

public interface Generator<T> {
	public void generate(T object, String path) throws IOException;
	public String generate(T object); // TODO does this need to return a String...?
}
