package Galaxy.Tree.Tool;

import Galaxy.Visitor.DFSVisitor;

public class Data extends Output{
	private final String format;
	private final String name;
	
	public Data(String format, String name){
		this.format = format;
		this.name = name;
	}
	public Object accept(DFSVisitor.StepVisitor stepvisitor){
		return stepvisitor.visit(this);
	}
	public String getFormat(){
		return format;
	}
	public String getName(){
		return name;
	}
	
}
