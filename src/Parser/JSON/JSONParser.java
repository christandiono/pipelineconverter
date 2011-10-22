package Parser.JSON;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import GalaxyData.JSON.GalaxyJSONLoader;
import GalaxyData.Tree.Workflow.Workflow;
import Parser.Parser;

public class JSONParser implements Parser {
	
		public static Object parse(String filepath) {
			
			Gson gson = GalaxyJSONLoader.getLoader();
			//Parse workflow
			Workflow egg = null;
			try {
				egg = gson.fromJson(new FileReader(filepath),
										Workflow.class);
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return egg;
		}
		
		public static void generate(String path, Object w){
			Gson gson = GalaxyJSONLoader.getLoader();
			String jsonText = gson.toJson(w);
			System.out.println(jsonText);
		}
}
