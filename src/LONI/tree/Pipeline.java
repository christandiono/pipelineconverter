package LONI.tree;

import LONI.tree.GraphObject.ModuleGroup;



public class Pipeline extends LoniNode {
	private final String version;
	private final ModuleGroup pipelineModuleGroup;
	
	public Pipeline(String version, ModuleGroup myModuleGroup){
		this.pipelineModuleGroup =  myModuleGroup;
		this.version = version;
	}
}
