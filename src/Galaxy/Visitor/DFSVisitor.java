package Galaxy.Visitor;

import Galaxy.Tree.Workflow.ExternalInput;
import Galaxy.Tree.Workflow.ExternalOutput;
import Galaxy.Tree.Workflow.InputConnection;
import Galaxy.Tree.Workflow.Position;
import Galaxy.Tree.Workflow.Step;
import Galaxy.Tree.Workflow.Workflow;

public class DFSVisitor {

	public Object visit(Workflow workflow) {
		// TODO Auto-generated method stub
		for(Step s : workflow.getSteps()){
			stepVisitor.visit(s);
		}
		return null;
	}
	public StepVisitor stepVisitor = new StepVisitor();
	
	public class StepVisitor{
			public Object visit(Step s){
				return null;
			}
		
	};
	

}
