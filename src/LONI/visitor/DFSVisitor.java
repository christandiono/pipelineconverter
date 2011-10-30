package LONI.visitor;

import Galaxy.Tree.Workflow.Step;
import Galaxy.Visitor.DFSVisitor.StepVisitor;

public class DFSVisitor implements LoniVisitor{
	public StepVisitor stepVisitor = new StepVisitor();
	
	public class StepVisitor{
			public Object visit(Step s){
				return null;
			}
		
	};
}
