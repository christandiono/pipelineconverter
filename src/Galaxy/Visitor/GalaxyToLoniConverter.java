package Galaxy.Visitor;

import java.util.LinkedList;
import java.util.List;

import Core.Pair;
import Galaxy.Tree.Workflow.ExternalInput;
import Galaxy.Tree.Workflow.ExternalOutput;
import Galaxy.Tree.Workflow.InputConnection;
import Galaxy.Tree.Workflow.Position;
import Galaxy.Tree.Workflow.Step;
import Galaxy.Tree.Workflow.Workflow;

import LONI.tree.*;

public class GalaxyToLoniConverter extends DFSVisitor{

	@Override
	public Pipeline visit(Workflow workflow) {
		Pipeline genPipeline= new Pipeline();
		ModuleGroup rootGroup = genPipeline.getRootModuleGroup();
		
		for(Step s : workflow.getSteps()){
			Pair<Module, List<Connection>> pr= visit(s);
			rootGroup.addModule(pr.getElem1());
		}
		// TODO Auto-generated method stub
		return genPipeline;
	}

	@Override
	public Pair<Module, List<Connection>> visit(Step step){
		Module genModule;
		List<Connection> genConnection = new LinkedList<Connection>();
		genModule = new Module(step.getName(),
							   "",
							   step.getPosition().getFromLeft(),
							   step.getPosition().getFromTop());
	
		for(String sink : step.getConnectionSinks()){
			InputConnection src = step.getConnectionSource(sink);
			genConnection.add(new Connection(
					src.getSourceId()+"_"+src.getSourceName(),
					sink));
		}
		return new Pair(genModule, genConnection);
	}

	@Override
	public Object visit(ExternalInput externalInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExternalOutput externalOutput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(InputConnection inputConnection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Position position) {
		// TODO Auto-generated method stub
		return null;
	}
}
