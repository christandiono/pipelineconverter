package Specification;

import FileOps.JSON.JSONGenerator;
import FileOps.JSON.JSONParser;
import FileOps.JSON.GSON.GSONFileHandler;
import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Workflow.*;


public class GalaxySpecification {
	private static GSONFileHandler<GalaxyNode> gson = new GSONFileHandler<GalaxyNode>();
	private static JSONParser<GalaxyNode> jsonParser = gson;
	private static JSONGenerator<GalaxyNode> jsonGenerator = gson; 
	private static boolean initialized = false;
	
	private static void init(){
		initJSONParser();
		initJSONGenerator();
		initialized = true;
		
	}

	private static void initJSONGenerator(){
		
	}
	
	private static void initJSONParser(){
		jsonParser.bindTag(Workflow.class, "name", "name");
		jsonParser.bindTag(Workflow.class, "id", "ID");
		
	
	}
	
	
	public static JSONParser<GalaxyNode> getJSONParser(){
		if(!initialized)
			init();
		return jsonParser;
	}
	public static JSONGenerator<GalaxyNode> getJSONGenerator(){
		if(!initialized)
			init();
		return jsonGenerator;
	}
	

}
