package Galaxy.Tree.Workflow;

public class InputConnection {
	private final int sourceId;
	private final String outputName;
	
	public InputConnection(int sourceId, String outputName){
		this.sourceId = sourceId;
		this.outputName = outputName;
	}
	public String getSourceName(){
		return outputName;
		
	}
	public int getSourceId(){
		return sourceId;
	}
}


