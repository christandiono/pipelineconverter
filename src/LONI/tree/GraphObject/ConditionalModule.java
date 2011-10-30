package LONI.tree.GraphObject;

import LONI.tree.LoniNode;
import LONI.tree.Position;

public class ConditionalModule extends GraphObject {


	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String executableVersion;
	private final String description;
	private final String location;
	private final int rotation;
	private final String icon;
	private final String advancedOptions;
	private final boolean hasMetadata;
	
	public ConditionalModule(String id, String name, String myPackage, String version, 
			String executableVersion, String description, String location, int rotation, 
			String icon, String advancedOptions, boolean hasMetadata, Position position) {
		super(position);
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.executableVersion = executableVersion;
		this.description  =description;
		this.location = location;
		this.rotation = rotation;
		this.icon = icon;
		this.advancedOptions = advancedOptions;
		this.hasMetadata = hasMetadata;
		
		// TODO Auto-generated constructor stub
	}
}
