package Parser.JSON;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import GalaxyData.JSON.GalaxyJSONLoader;
import GalaxyData.Tree.Workflow;
import Parser.Parser;

public class JSONParser implements Parser {
	
		public static void parse(String filepath) {
			
			Gson gson = GalaxyJSONLoader.Loader;
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
			
		}
		
		public static void generate(String path, Workflow w){
			Gson gson = GalaxyJSONLoader.Loader;
			String jsonText = gson.toJson(w);
			try{
				  // Create file 
				  FileWriter fstream = new FileWriter(path);
				  BufferedWriter out = new BufferedWriter(fstream);
				  out.write(jsonText);
				  //Close the output stream
				  out.close();
				  }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
			
		}
}
