package Galaxy.Visitor;

import java.util.ArrayList;
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
import LONI.tree.GraphObject.Module;
import LONI.tree.GraphObject.ModuleGroup;

public class GalaxyToLoniConverter extends DFSVisitor
{
	private static int MGROUP_COUNT=0;
	
	public String getModuleGroup(){
		String s = "mgrp" + MGROUP_COUNT;
		MGROUP_COUNT++;
		return s;
	}


	public Object visit(Workflow workflow) 
	{
		Pipeline pipeline;
		ModuleGroup mgroup;
		String annotation = workflow.getAnnotation();
		String version = workflow.getFormatVersion();
		String name = workflow.getName();
		mgroup = new ModuleGroup(getModuleGroup(), 
				name, "package", "version", annotation, 
				"icon", 0, new LONI.tree.Position(0,0), false);
		
		
		for(Step s : workflow.getSteps()){
			Pair<Module, List<Connection>> dat;
			dat = (Pair<Module, List<Connection>>) stepVisitor.visit(s);
			
			//mgroup.getConnections().addConnections(dat.getElem2());
			mgroup.getModules().add(dat.getElem1());
			
		}
		
		pipeline = new Pipeline(version, mgroup);
		
		return pipeline;
	}
	{
		stepVisitor = new StepVisitor() {
			public Pair<Module, List<Connection>> visit(Step step){
				Module genModule;
				List<Connection> genConnection = new LinkedList<Connection>();
				
				LONI.tree.Position position = new LONI.tree.Position(0,0);
				genModule = new Module(position, step.getToolId(), step.getName(), 
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
