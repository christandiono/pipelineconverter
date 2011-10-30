package LONI.tree.GraphObject;

import LONI.tree.LoniNode;

public class StudyModule extends GraphObject {


	
	private final String id;
	private final String name;
	private final String myPackage;
	private final String version;
	private final String description;
	private final boolean isGroupAsOutput;
	private final int rotation;
	private final String type;
	private final boolean dirSource;
	private final String importStudyRule;
	private final String derivedDataTag;
	private final boolean useDirSourceFilters;
	private final int dirSourceFilterType;
	private final boolean recursive;
	
	public StudyModule(String id, String name, String myPackage,
			String version, String description, 
			boolean isGroupAsOutput, int rotation, String type,
			boolean dirSource, String importStudyRule, String derivedDataTag,
			boolean useDirSourceFilters, int dirSourceFilterType,
			boolean recursive, int posX, int posY) {
		super(posX, posY);
		this.id = id;
		this.name = name;
		this.myPackage = myPackage;
		this.version = version;
		this.description = description;
		this.isGroupAsOutput = isGroupAsOutput;
		this.rotation = rotation;
		this.type = type;
		this.dirSource = dirSource;
		this.importStudyRule = importStudyRule;
		this.derivedDataTag = derivedDataTag;
		this.useDirSourceFilters = useDirSourceFilters;
		this.dirSourceFilterType = dirSourceFilterType;
		this.recursive = recursive;
	}
}
