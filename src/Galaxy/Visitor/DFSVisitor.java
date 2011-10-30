package Galaxy.Visitor;

import Galaxy.Tree.Tool.*;
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
			public Object visit(Parameter p){
				return null;
				
			}
			public Object visit(Data d){
				return null;
				
			}
		
	};
	

}
