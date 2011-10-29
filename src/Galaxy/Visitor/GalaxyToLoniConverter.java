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

public class GalaxyToLoniConverter extends DFSVisitor
{


	public Pipeline visit(Workflow workflow) 
	{
		Pipeline pipeline = new Pipeline();
		return pipeline;
	}
	{
		stepVisitor = new StepVisitor() {
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
		};
	}
}
