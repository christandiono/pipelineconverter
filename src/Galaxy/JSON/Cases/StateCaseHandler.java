package Galaxy.JSON.Cases;


import java.lang.reflect.Type;

import Galaxy.Tree.*;
import Galaxy.Tree.Workflow.State;


import Parser.JSON.CaseHandler;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;

public class StateCaseHandler extends CaseHandler<State>{
		
		public StateCaseHandler(){
			super(State.class);
		}
		
		public State deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			// TODO Auto-generated method stub
			State translatedState = new State();
			translatedState.state_elems.put("KEY", json.getAsString().toUpperCase());
			return translatedState;
		}

		@Override
		public JsonElement serialize(State src, Type typeOfSrc,
				JsonSerializationContext context) {
			// TODO Auto-generated method stub
			System.out.println("SPECIAL CASE: FOR SERIALIZE");
			return context.serialize(src.state_elems.toString());
		}

		
}
