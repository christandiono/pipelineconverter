package LONI.tree.GraphObject;

import LONI.tree.LoniNode;
import LONI.tree.Position;

public class ViewerModule extends GraphObject {


	
	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final String location;
	private final int rotation;
	private final String icon;
	
	public ViewerModule(Position position, String id, String name,
			String myPackage, String version, String description,
			String location, int rotation, String icon) {
		super(position);
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.description = description;
		this.location = location;
		this.rotation = rotation;
		this.icon = icon;
	}
}
