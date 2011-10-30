package LONI.tree;

import LONI.tree.GraphObject.ModuleGroup;



public class Pipeline extends LoniNode {
	private final String version;
	private final ModuleGroup pipelineModuleGroup;
	
	public Pipeline(String version, String id, String name, String myPackage,
					String moduleVersion, String description, String icon, 
					Position position, int rotation,
					boolean needsProvenence){
		this.pipelineModuleGroup = 
			new ModuleGroup(version, version, version, 
						version, version, version, 0, 
						null, false);
		this.version = version;
	}
}
