package LONI.tree;

public class Pipeline extends LoniNode{
	Float Version;
	ModuleGroup Workflow;
	
	public Pipeline(){
		Workflow = new ModuleGroup();
	}

	public ModuleGroup getRootModuleGroup(){
		return Workflow;
	}
}
