package LONI.tree.GraphObject;

import java.util.ArrayList;
import java.util.List;

import LONI.tree.Connections;
import LONI.tree.LoniNode;
import LONI.tree.Position;



public class ModuleGroup extends GraphObject {
	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final String icon;
	private final int rotation;
	private final boolean needsProvenance;
	List<GraphObject> modules;
	Connections connections;
	
	public ModuleGroup(String id, String name, String myPackage,
			String version, String description, String icon, int rotation,
			Position position, boolean needsProvenance) {
		super(position);
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.description = description;
		this.icon = icon;
		this.rotation = rotation;
		this.needsProvenance = needsProvenance;
		connections = new Connections();
		modules = new ArrayList<GraphObject>();
	}
	
}
