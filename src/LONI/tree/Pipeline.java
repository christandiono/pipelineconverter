package LONI.tree;

import LONI.tree.GraphObject.ModuleGroup;



public class Pipeline extends LoniNode {
	public String getVersion() {
		return version;
	}

	public ModuleGroup getPipelineModuleGroup() {
		return pipelineModuleGroup;
	}
	
	public Connections getConnections() {
		return connections;
	}


	private final String version;
	private final ModuleGroup pipelineModuleGroup;
	Connections connections;
	
	public Pipeline(String version, ModuleGroup myModuleGroup, Connections connections) {
		this.pipelineModuleGroup =  myModuleGroup;
		this.version = ".1";
		this.connections = connections;
	}
}
