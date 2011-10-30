package LONI.tree.GraphObject;


public class GraphObject {
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	private final int posX;
	private final int posY;
	
	public GraphObject(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
}
