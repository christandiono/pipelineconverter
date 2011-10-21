package GalaxyData.JSON;

import GalaxyData.JSON.Cases.StateCaseHandler;
import GalaxyData.JSON.Strategies.GExclusionStrategy;
import GalaxyData.JSON.Strategies.GFieldNamingStrategy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GalaxyJSONLoader {
	public static Gson Loader;
	{
		GsonBuilder loaderBuilder = new GsonBuilder();
		loaderBuilder.setFieldNamingStrategy(new GFieldNamingStrategy());
		loaderBuilder.addDeserializationExclusionStrategy(new GExclusionStrategy());
		
		loaderBuilder.registerTypeAdapter((new StateCaseHandler()).getType(), StateCaseHandler.class);
	
		Loader = loaderBuilder.create();
	}

}
