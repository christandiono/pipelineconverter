package GalaxyData.JSON.Strategies;


import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;

public class GFieldNamingStrategy implements FieldNamingStrategy{

	@Override
	public String translateName(Field f) {
		// TODO Auto-generated method stub
		return f.getName();
	}

	
}
