package Galaxy.Tree.Workflow;

public class Position {
	private final int unitsFromLeftMargin;
	private final int unitsFromTopMargin;
	
	public Position(int unitsFromLeftMargin, int unitsFromTopMargin){
		this.unitsFromLeftMargin = this.unitsFromLeftMargin;
		this.unitsFromTopMargin = this.unitsFromTopMargin;
	}
	public Integer getFromLeft(){
		return unitsFromLeftMargin;
	}
	public Integer getFromTop(){
		return unitsFromTopMargin;
	}
	
}
