package Parser.JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import GalaxyData.JSON.GalaxyJSONLoader;
import GalaxyData.Tree.Workflow;
import Parser.Parser;

public class JSONParser implements Parser {
	
		public static void parse() throws JsonSyntaxException, JsonIOException, FileNotFoundException{
			
			Gson gson = GalaxyJSONLoader.Loader;
			//Parse workflow
			Workflow egg = gson.fromJson(new FileReader("src/Parser/test.ga"),
									Workflow.class);
			System.out.println(gson.toJson(egg));
		}
}
