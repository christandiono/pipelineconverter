package LONI.tree;

import java.util.List;



public class ModuleGroup extends LoniNode {
	

	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final String icon;
	Position position;
	private final int rotation;
	private final boolean needsProvenance;
	
	public ModuleGroup(String id, String name, String myPackage,
			String version, String description, String icon, int rotation,
			Position position, boolean needsProvenance) {
		super();
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.position = position;
		this.description = description;
		this.icon = icon;
		this.rotation = rotation;
		this.needsProvenance = needsProvenance;
	}
	
}
