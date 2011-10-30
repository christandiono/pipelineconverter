package LONI.tree;

public class Parameter extends LoniNode {


	private String id;
	private String name;
	private String description;
	private boolean enabled;
	private boolean required;
	private boolean predefined;
	private boolean isMetadata;
	private boolean isListFile;
	private boolean isHideData;
	private boolean includeTransformedParameter;
	private int order;
	private String prefix;
	private boolean prefixSpaced;
	private boolean prefixAllArgs;
}
