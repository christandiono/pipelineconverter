package GalaxyData.JSON.Strategies;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class GExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		// TODO Auto-generated method stub
		return false;
	}

}
