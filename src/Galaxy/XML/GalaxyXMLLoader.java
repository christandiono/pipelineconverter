package Galaxy.XML;

import Galaxy.JSON.Cases.StateCaseHandler;
import Galaxy.JSON.Strategies.GExclusionStrategy;
import Galaxy.JSON.Strategies.GFieldNamingStrategy;
import Galaxy.Tree.Tool.Tool;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class GalaxyXMLLoader {
	private static XStream Loader;
	private static void initLoader()
	{
		Loader = new XStream(new StaxDriver());
		Loader.alias("tool", Tool.class);
		Loader.aliasAttribute(Tool.class, "name", "name");
	}
	public static XStream getLoader(){
		if(Loader == null)
			GalaxyXMLLoader.initLoader();
		return GalaxyXMLLoader.Loader;
	}

}
