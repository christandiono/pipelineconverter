package FileOps.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import FileOps.Generator;
import FileOps.Parser;

public class XStreamWrapper<T> implements Parser<T>, Generator<T>{

	@Override
	public T parse(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T parse(File json) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generate(T object, String path) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generate(T object) {
		// TODO Auto-generated method stub
		return null;
	}

}
