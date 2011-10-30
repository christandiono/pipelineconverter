package LONI.tree;

public class ModuleGroup extends LoniNode {
	
	private String id;
	private String name;
	private String myPackage;
	private String version;
	private String description;
	private String icon;
	Position position;
	private int rotation;
	private boolean needsProvenance;
	
	
	public ModuleGroup(String id, String name, String myPackage,
			String version, String description, String icon, int rotation,
			Position position,
			boolean needsProvenance) {
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
