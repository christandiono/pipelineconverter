package LONI.tree.GraphObject;

import LONI.tree.LoniNode;

public class Module extends LoniNode {


	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String executableVersion;
	private final String description;
	private final String location;
	private final int posX;
	private final int posY;
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
}
