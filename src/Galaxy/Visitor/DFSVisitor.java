package Galaxy.Visitor;

import Galaxy.Tree.Workflow.ExternalInput;
import Galaxy.Tree.Workflow.ExternalOutput;
import Galaxy.Tree.Workflow.InputConnection;
import Galaxy.Tree.Workflow.Position;
import Galaxy.Tree.Workflow.Step;
import Galaxy.Tree.Workflow.Workflow;

public class DFSVisitor<T> implements GalaxyVisitor<T> {

	@Override
	public T visit(Workflow workflow) {
		// TODO Auto-generated method stub
		for(Step s : workflow.getSteps()){
			visit(s);
		}
		return null;
	}

	@Override
	public T visit(Step step) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(ExternalInput externalInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(ExternalOutput externalOutput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(InputConnection inputConnection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(Position position) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class StepVisitor{
			public Object visit(Step s){
				return null;
			}
		
	};
	StepVisitor stepVisitor;
	

}
