package LONI.tree;

public class Position {
	private final final int posX;
	private final final int posY;
	
	public Position(int x, int y){
		posX = x;
		posY = y;
	}
	
	public int getX(){
		return posX;
	}
	public int getY(){
		return posY;
	}
}
