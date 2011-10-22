package GalaxyData.JSON;

import GalaxyData.JSON.Cases.StateCaseHandler;
import GalaxyData.JSON.Strategies.GExclusionStrategy;
import GalaxyData.JSON.Strategies.GFieldNamingStrategy;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GalaxyJSONLoader {
	private static Gson Loader;
	private static void initLoader() {
		GsonBuilder loaderBuilder = new GsonBuilder();
		loaderBuilder.setFieldNamingStrategy(new GFieldNamingStrategy());
		loaderBuilder.addDeserializationExclusionStrategy(new GExclusionStrategy());
		loaderBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
		//loaderBuilder.registerTypeAdapter((new StateCaseHandler()).getType(), StateCaseHandler.class);
	
		Loader = loaderBuilder.create();
	}
	public static Gson getLoader(){
		if(Loader == null)
			GalaxyJSONLoader.initLoader();
		
		return GalaxyJSONLoader.Loader;
	}

}