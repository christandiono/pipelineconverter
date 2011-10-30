package LONI.visitor;

import java.util.LinkedList;
import java.util.List;

import Core.Pair;
import Galaxy.Tree.GalaxyNode;
import Galaxy.Tree.Workflow.InputConnection;
import Galaxy.Tree.Workflow.Position;
import Galaxy.Tree.Workflow.Step;
import Galaxy.Tree.Workflow.Workflow;
import Galaxy.Visitor.DFSVisitor.StepVisitor;
import LONI.tree.Connection;
import LONI.tree.Connections;
import LONI.tree.Pipeline;
import LONI.tree.GraphObject.GraphObject;
import LONI.tree.GraphObject.Module;
import LONI.tree.GraphObject.ModuleGroup;

public class LoniToGalaxyConverter extends DFSVisitor {
	private static int NODE_COUNT = 0;
	
	public int getId() {
		return NODE_COUNT++; /* whoa, using post-decrement properly in java! */
	}

	public Object visit(Pipeline pipeline) {
		Workflow workflow;
		ModuleGroup mgroup = pipeline.getPipelineModuleGroup();
		List<GraphObject> modules = mgroup.getModules();
		Connections conns = pipeline.getConnections();
		
		workflow = new Workflow(mgroup.getName(), mgroup.getDescription(), pipeline.getVersion(), true);
		
		for (GraphObject m : modules) {
			Module m1 = (Module) m;
//			genModule = new Module(position, step.getToolId(), step.getName(), 
//					"package", step.getToolVersion(), "executableVersion", step.getAnnotation() ,
//					"pipeline://localhost/", 0, "icon", "advancedOptions", false, false, false, false, "sourceCode", 
//					false, false, "mPIParallelEnv", "mPINumSlots", false);
			//GalaxyNode gn = new GalaxyNode();
			//m1 = new Module(position, id, name, myPackage, version, executableVersion, description, location, rotation, icon, advancedOptions, smartModule, isIDAModule, isXNATModule, isRepeatUntil, sourceCode, requireNetAccess, mPIEnabled, mPIParallelEnv, mPINumSlots, preserveInputFilename)
			Step step = new Step(getId(), m1.getName(), m1.getDescription(), m1.getId(), m1.getVersion(),"", "tool", new Position(m1.getPosX(), m1.getPosY()));
			workflow.addStep(step.getId(), step);
			//Step s1 = new Step(id, name, annotation, toolId, toolVersion, toolState, toolType, stepPosition)
		}

		return workflow;
//		
//		
//		ModuleGroup mgroup;
//		String annotation = workflow.getAnnotation();
//		String version = workflow.getFormatVersion();
//		String name = workflow.getName();
//		mgroup = new ModuleGroup(getModuleGroup(), 
//				name, "package", "version", annotation, 
//				"icon", 0, new LONI.tree.Position(0,0), false);
//		
//		
//		for(Step s : workflow.getSteps()){
//			Pair<Module, List<Connection>> dat;
//			dat = (Pair<Module, List<Connection>>) stepVisitor.visit(s);
//			
//			//mgroup.getConnections().addConnections(dat.getElem2());
//			mgroup.getModules().add(dat.getElem1());
//			
//		}
//		
//		pipeline = new Pipeline(version, mgroup);
//		
//		return pipeline;
	}
	{
		stepVisitor = new StepVisitor() {
			public Pair<Module, List<Connection>> visit(Step step){
				Module genModule;
				List<Connection> genConnection = new LinkedList<Connection>();
				
				genModule = new Module( 0, 0, step.getToolId(), step.getName(), 
						"package", step.getToolVersion(), "executableVersion", step.getAnnotation() ,
						"pipeline://localhost/", 0, "icon", "advancedOptions", false, false, false, false, "sourceCode", 
						false, false, "mPIParallelEnv", "mPINumSlots", false);
				
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
