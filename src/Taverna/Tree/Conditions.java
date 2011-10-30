package Taverna.Tree;

import java.util.ArrayList;
import java.util.List;

public class Conditions extends TavernaNode {
	public Conditions(){
		conditions = new ArrayList<Condition>();
	}
	
	public void addCondition(Condition c){
		conditions.add(c);
	}
	
	public List<Condition> getConditions(){
		return conditions;
	}
	
	private List<Condition> conditions;
}
