package LONI.tree.GraphObject;

import LONI.tree.LoniNode;
import LONI.tree.Position;

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
	
	public Annotation(Position position, String type, boolean expanded,
			String name, String width, String height, String posX, String posY,
			String background, String foreground) {
		super(position);
		this.type = type;
		this.expanded = expanded;
		this.name = name;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
		this.background = background;
		this.foreground = foreground;
	}
}


