package LONI.tree;

import java.util.List;

public class ModuleGroup extends LoniNode{
	String Name;
	String ID;
	String Package;
	String Version;
	String Description;
	Integer PositionX;
	Integer PositionY;
	List<Module> Modules;	// How do judge to creat this? because it's group?
}
