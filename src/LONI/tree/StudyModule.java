import LONI.tree.LoniNode;

package LONI.tree;

public class StudyModule extends LoniNode {


	private String id;
	private String name;
	private String myPackage;
	private String version;
	private String description;
	private int posX;
	private int posY;
	private boolean isGroupAsOutput;
	private int rotation;
	private String type;
	private boolean dirSource;
	private String importStudyRule;
	private String derivedDataTag;
	private boolean useDirSourceFilters;
	private int dirSourceFilterType;
	private boolean recursive;
}
