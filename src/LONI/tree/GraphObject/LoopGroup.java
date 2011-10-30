package LONI.tree.GraphObject;

import LONI.tree.LoniNode;

public class LoopGroup extends GraphObject {


	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final String icon;
	private final int rotation;
	private final boolean needsProvenance;
	
	public LoopGroup(String id, String name, String myPackage, String version,
			String description, String icon, int rotation, boolean needsProvenance,
			int posX, int posY)
	{
		super(posX, posY);
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.rotation = rotation;
		this.version = version;
		this.needsProvenance = needsProvenance;
		this.description = description;
		this.myPackage = myPackage;
		

	}
}