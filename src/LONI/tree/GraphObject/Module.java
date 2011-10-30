package LONI.tree.GraphObject;

import java.util.ArrayList;
import java.util.List;

import LONI.tree.LoniNode;
import LONI.tree.Parameter;

public class Module extends GraphObject {


	
	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String executableVersion;
	private final String description;
	private final String location;
	private final int rotation;
	private final String icon;
	private final String advancedOptions;
	private final boolean smartModule;
	private final boolean isIDAModule;
	private final boolean isXNATModule;
	private final boolean isRepeatUntil;
	private final String sourceCode;
	private final boolean requireNetAccess;
	private final boolean MPIEnabled;
	private final String MPIParallelEnv;
	private final String MPINumSlots;
	private final boolean preserveInputFilename;
	private final List<Parameter> inputs;
	private final List<Parameter> outputs;
	
	
	public Module(int posX, int posY, String id, String name, String myPackage,
			String version, String executableVersion, String description,
			String location, int rotation, String icon, String advancedOptions,
			boolean smartModule, boolean isIDAModule, boolean isXNATModule,
			boolean isRepeatUntil, String sourceCode, boolean requireNetAccess,
			boolean mPIEnabled, String mPIParallelEnv, String mPINumSlots,
			boolean preserveInputFilename) {
		super(posX, posY);
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.executableVersion = executableVersion;
		this.description = description;
		this.location = location;
		this.rotation = rotation;
		this.icon = icon;
		this.advancedOptions = advancedOptions;
		this.smartModule = smartModule;
		this.isIDAModule = isIDAModule;
		this.isXNATModule = isXNATModule;
		this.isRepeatUntil = isRepeatUntil;
		this.sourceCode = sourceCode;
		this.requireNetAccess = requireNetAccess;
		MPIEnabled = mPIEnabled;
		MPIParallelEnv = mPIParallelEnv;
		MPINumSlots = mPINumSlots;
		this.preserveInputFilename = preserveInputFilename;
		this.inputs = new ArrayList<Parameter>();
		this.outputs = new ArrayList<Parameter>();
	}
	
	public List<Parameter> getInputs(){
		return this.inputs;
	}
	public List<Parameter> getOutputs(){
		return this.outputs;
	}
	public void addInput(Parameter p){
		this.inputs.add(p);
	}
	public void addOutput(Parameter p){
		this.outputs.add(p);
	}
	public void addInputs(List<Parameter> p){
		this.inputs.addAll(p);
	}
	public void addOutputs(List<Parameter>  p){
		this.outputs.addAll(p);
	}
	
	
}
