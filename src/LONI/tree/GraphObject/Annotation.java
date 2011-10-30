package LONI.tree.GraphObject;

import LONI.tree.LoniNode;

public class Annotation extends GraphObject {


	
	private String type;
	private boolean expanded;
	private String name;
	private String width;
	private String height;
	private String posX;
	private String posY;
	private String background;
	private String foreground;
	
	public Annotation(int posX, int posY, String type, boolean expanded,
			String name, String width, String height, 
			String background, String foreground) {
		super(posX, posY);
		this.type = type;
		this.expanded = expanded;
		this.name = name;
		this.width = width;
		this.height = height;
		this.background = background;
		this.foreground = foreground;
	}
}


