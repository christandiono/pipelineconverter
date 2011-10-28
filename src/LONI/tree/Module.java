package LONI.tree;

import java.util.List;

public class Module extends LoniNode {
	String ID;
	String Location;
	Integer PositionX;
	Integer PositionY;
	public Module(String id, String location, Integer PositionX, Integer PositionY){
		this.ID = id;
		this.Location = location;
		this.PositionX = PositionX;
		this.PositionY = PositionY;
	}
	

}
