package LONI.tree;

public class Pipeline extends LoniNode {
	private final final String version;
	private final final ModuleGroup pipelineModuleGroup;
	List<>
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
